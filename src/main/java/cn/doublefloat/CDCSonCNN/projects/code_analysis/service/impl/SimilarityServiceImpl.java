package cn.doublefloat.CDCSonCNN.projects.code_analysis.service.impl;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.AlgorithmCodes;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.service.SimilarityService;
import org.springframework.stereotype.Service;

/**
 * @author 魏荣轩
 * @date 2020/11/21 11:28
 */
@Service
public class SimilarityServiceImpl implements SimilarityService {

    /**
     * 获取分析器
     *
     * @return 分析器
     */
    @Override
    public AlgorithmCodes getAlgorithmCodeTool() {
        return new AlgorithmCodes();
    }
}
