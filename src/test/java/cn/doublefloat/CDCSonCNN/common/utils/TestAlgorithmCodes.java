package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.AlgorithmCodes;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.utils.DelComments;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 魏荣轩
 * @date 2020/11/5 22:04
 */
class TestAlgorithmCodes {


    @Test
    void testDelComments(){
        String codes = TxtFileUtils.readTxtFile("codes/Txt/TestCode1.txt").toString();
        System.out.println(codes);
        System.out.println("=============================");
        System.out.println(DelComments.delComments(codes));
    }

    @Test
    void testCNNByPython(){
        System.out.println(new AlgorithmCodes().
                getSimilarityByPython("vars int vars if vars 0 else vars max return vars M920 D25 java2 windows GDIWindowSurfaceData util Arrays public vars class vars 66 public vars ",
                "class vars 53 public vars static vars void vars int vars new vars int vars 2 1 3 4 1 2 1 5 4 out println public vars static vars int vars int",
                        "model\\java_model.model"));
    }
}
