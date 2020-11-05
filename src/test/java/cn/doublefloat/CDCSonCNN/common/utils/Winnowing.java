package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.common.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.common.code_anlysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:16
 */
class Winnowing {
    @Test
    void testWinnowing(){
        cn.doublefloat.CDCSonCNN.common.code_anlysis.algorithm.winnowing.Winnowing winnowing
                = new cn.doublefloat.CDCSonCNN.common.code_anlysis.algorithm.winnowing.Winnowing();
        CodesCompare cmp = new CodesCompare();
        System.out.println(winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/C/18090241-190824.c").toString()));
        System.out.println(winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/C/18090241-190825.c").toString()));
        System.out.println("========================================");
        System.out.println(new BigDecimal(CodesCompare.getCodesSimilarity(
                "codes/C/18090241-190824.c", "codes/C/18090241-190825.c"))
                .setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
