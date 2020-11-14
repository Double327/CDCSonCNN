package cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.configEumn.Value;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.configEumn.Weight;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.simhash.SimHash;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.winnowing.Winnowing;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.utils.TxtFileUtils;
import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis.SimilarityCodeList;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:56
 */
public class AlgorithmCodes {
    public AlgorithmCodes(){ }
    /**
     * 三权法
     * simHash = w1
     * winnowing = w2
     * compare = w3
     * 加权: Similarity(code1,code2) = (w1/(1+DL_simHash)) + Sm_winnowing*w2 + Cmp_Sim*w3
     *
     * @param codeFile1 代码文件1
     * @param codeFile2 代码文件2
     * @return 匹配度 (四位小数)
     */
    public double simWinCompareSimilarity(String codeFile1,String codeFile2){
        //三权分析
        double compareSimilarity = new BigDecimal(CodesCompare.getCodesSimilarity(codeFile1, codeFile2))
                .setScale(Value.PERCENTAGE_DECIMAL.getValue(), BigDecimal.ROUND_HALF_UP).doubleValue() ;
        double simHashDistance = SimHash.getSimHashDistance(TxtFileUtils.readTxtFile(codeFile1).toString(),
                TxtFileUtils.readTxtFile(codeFile2).toString(),Value.HAMMING_DISTANCE.getValue()) ;
        Winnowing winnowing = new Winnowing();
        Set<Integer> code1Set = winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile(codeFile1).toString());
        Set<Integer> code2Set = winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile(codeFile2).toString());
        //进行hash表匹配
        double winnowingSimilarity = winnowing.getSimilarity(code1Set,code2Set);
        //返回加权结果  Weight.SIMHASH_WEIGHT.getWeight()/(1+simHashDistance)
        return new BigDecimal(Weight.SIMHASH_WEIGHT.getWeight()/simHashDistance +
                winnowingSimilarity * Weight.WINNOWING_WEIGHT.getWeight() +
                compareSimilarity * Weight.COMPARE_WEIGHT.getWeight())
                .setScale(Value.PERCENTAGE_DECIMAL.getValue(), BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public SimilarityCodeList simWinCompareSimilarity(String codeFile){
        //遍历所有代码文件获取相似度文件集合
        //do something
        //预留cnn返回结果生成SimilarityCodeList对象并返回
        return new SimilarityCodeList();
    }
}
