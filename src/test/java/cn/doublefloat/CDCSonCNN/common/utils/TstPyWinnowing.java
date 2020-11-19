package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.utils.DelComments;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.utils.DelVariables;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.other_old_anlysis.winnowing.PyWinnowing;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 魏荣轩
 * @date 2020/11/17 23:43
 */
public class TstPyWinnowing {
    @Test
    void testWinnowingPy(){
        String code = TxtFileUtils.readTxtFile("codes/C/18090241-190824.c").toString();
        code = DelComments.delComments(code);
        code = DelVariables.delVariables(code,"","");
        String vector = PyWinnowing.getPythonWinnowingResult(code);
        System.out.println(vector);
    }
}
