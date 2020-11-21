package cn.doublefloat.CDCSonCNN.projects.code_analysis.controller;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.service.SimilarityService;
import cn.doublefloat.CDCSonCNN.projects.system.domain.vo.code_anlysis.SimilarityCodeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 魏荣轩
 * @date 2020/11/21 11:26
 */
@Controller
public class SimilarityController {

    @Autowired
    private SimilarityService similarityService;

    /**
     * 获取所有其它代码的相似度 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNCompareSimilarity(String codeFile){
        return similarityService.getAlgorithmCodeTool().getCNNCompareSimilarity(codeFile);
    }

    /**
     * 获取超过阀值相似度的所有代码列表 - 卷积神经网络查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getCNNOverThresholdCodeFile(String codeFile, double threshold){
        return similarityService.getAlgorithmCodeTool().getCNNOverThresholdCodeFile(codeFile,threshold);
    }

    /**
     * 获取所有代码相似度 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultCompareSimilarity(String codeFile){
        return similarityService.getAlgorithmCodeTool().getDefaultCompareSimilarity(codeFile);
    }

    /**
     * 获取所有超过指定阀值的相似代码 - 普通算法查重
     *
     * @param codeFile 需要匹配的代码文件ID
     * @param threshold 阀值
     * @return SimilarityCodeList
     */
    public SimilarityCodeList getDefaultOverThresholdCodeFile(String codeFile, double threshold){
        return similarityService.getAlgorithmCodeTool().getDefaultOverThresholdCodeFile(codeFile,threshold);
    }

    /**
     * 获取两个代码文件的相似度 - 卷积神经网络
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getCNNSimilarity(String codeFile1, String codeFile2){
        return similarityService.getAlgorithmCodeTool().getCNNSimilarity(codeFile1,codeFile2);
    }

    /**
     * 获取两个代码文件的相似度 - 普通算法查重
     *
     * @param codeFile1 代码1
     * @param codeFile2 代码2
     * @return 相似度 0-1
     */
    public double getDefaultSimilarity(String codeFile1, String codeFile2){
        return similarityService.getAlgorithmCodeTool().getDefaultSimilarity(codeFile1,codeFile2);
    }


}
