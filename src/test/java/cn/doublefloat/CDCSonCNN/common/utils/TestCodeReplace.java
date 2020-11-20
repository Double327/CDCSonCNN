package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.projects.code_analysis.algorithm.cnn.pretreatment.CodeVectorTools;
import cn.doublefloat.CDCSonCNN.projects.code_analysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 魏荣轩
 * @date 2020/11/19 19:21
 */
public class TestCodeReplace {
    @Test
    void testCNNReplace(){
       System.out.println(
               CodeVectorTools.getCodePretreatmentAsString(
                       TxtFileUtils.readTxtFile("codes/C/18090241-190825.c").toString()));
    }
}
