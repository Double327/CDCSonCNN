package cn.doublefloat.CDCSonCNN.project.student.utils;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author 魏荣轩
 * @date 2020/10/28 18:12
 */
public class CodesCompareTest {
    @Test
    public void textCompare(){
        System.out.println("TestCode1.cpp & TestCode2.cpp = "+
                new BigDecimal(CodesCompare.getCodesSimilarity("codes/Txt/TestCode1.txt", "codes/Cpp/TestCode2.cpp"))
                        .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+"%");
    }
}
