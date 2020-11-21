package cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.cnn;

import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis.SimilarityCodeList;

/**
 * @author 魏荣轩
 * @date 2020/11/20 23:53
 */
public interface CNNAnalysis {
    /**
     * 获取超过阀值相似度的所有代码列表 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    SimilarityCodeList getCNNOverThresholdCodeFile(String codeFile, double threshold);

    /**
     * 获取所有其它代码的相似度 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    SimilarityCodeList getCNNCompareSimilarity(String codeFile);

    /**
     * 获取所有代码相似度 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    SimilarityCodeList getDefaultCompareSimilarity(String codeFile);

    /**
     * 获取所有超过指定阀值的相似代码 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    SimilarityCodeList getDefaultOverThresholdCodeFile(String codeFile, double threshold);

    /**
     * 获取两个代码文件的相似度 - 卷积神经网络
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    double getCNNSimilarity(String codeFile1, String codeFile2);

    /**
     * 获取两个代码文件的相似度 - 普通算法查重
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    double getDefaultSimilarity(String codeFile1, String codeFile2);
}
