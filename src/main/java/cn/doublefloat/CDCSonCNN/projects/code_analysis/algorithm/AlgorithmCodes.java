package cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.cnn.CNNAnalysis;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.other_old_analysis.configEumn.Value;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.other_old_analysis.configEumn.Weight;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.duplicateRemovalAnalysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.other_old_analysis.simhash.SimHash;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.other_old_analysis.winnowing.old.Winnowing;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.utils.TxtFileUtils;
import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis.SimilarityCodeList;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:56
 */
public class AlgorithmCodes implements CNNAnalysis {
    public AlgorithmCodes(){ }

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
