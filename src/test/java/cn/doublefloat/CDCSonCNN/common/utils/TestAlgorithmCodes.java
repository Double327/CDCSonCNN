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
    void testAlgorithmCodes(){
        AlgorithmCodes algorithmCodes = new AlgorithmCodes();
        System.out.println("Similarity: "+(algorithmCodes.simWinCompareSimilarity("codes/C/18090241-190826.c"
                ,"codes/C/18090241-190821.c")*100) +"%");
    }

    @Test
    void testDelComments(){
        String codes = TxtFileUtils.readTxtFile("codes/Txt/TestCode1.txt").toString();
        System.out.println(codes);
        System.out.println("=============================");
        System.out.println(DelComments.delComments(codes));
    }
}
