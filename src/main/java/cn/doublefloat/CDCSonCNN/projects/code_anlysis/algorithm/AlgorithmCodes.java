package cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.other_old_anlysis.configEumn.Value;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.other_old_anlysis.configEumn.Weight;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.other_old_anlysis.simhash.SimHash;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.other_old_anlysis.winnowing.old.Winnowing;
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
    @Deprecated
    public double simWinCompareSimilarity(String codeFile1,String codeFile2){
        //三权分析
        double compareSimilarity = new BigDecimal(new CodesCompare().getCodesSimilarity(codeFile1, codeFile2))
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

    /**
     * 获取所有其它代码的相似度 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNCompareSimilarity(String codeFile){
        //遍历所有代码文件获取相似度文件集合
        //do something
        //预留cnn返回结果生成SimilarityCodeList对象并返回
        return new SimilarityCodeList();
    }

    /**
     * 获取超过阀值相似度的所有代码列表 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNOverThresholdCodeFile(String codeFile, double threshold){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取所有代码相似度 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultCompareSimilarity(String codeFile){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取所有超过指定阀值的相似代码 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultOverThresholdCodeFile(String codeFile, double threshold){
        //do something
        return new SimilarityCodeList();
    }

    /**
     * 获取两个代码文件的相似度 - 卷积神经网络
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getCNNSimilarity(String codeFile1, String codeFile2){

        return 0D;
    }

    /**
     * 获取两个代码文件的相似度 - 普通算法查重
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getDefaultSimilarity(String codeFile1, String codeFile2){

        return 0D;
    }
}
