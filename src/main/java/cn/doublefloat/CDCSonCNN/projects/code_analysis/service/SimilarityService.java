package cn.doublefloat.CDCSonCNN.projects.code_analysis.service;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.AlgorithmCodes;

/**
 * @author 魏荣轩
 * @date 2020/11/21 11:27
 */

public interface SimilarityService {
    /**
     * 获取分析器
     *
     * @return 分析器
     */
    AlgorithmCodes getAlgorithmCodeTool();
}
