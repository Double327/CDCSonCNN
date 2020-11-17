package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.projects.code_anlysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:16
 */
class Winnowing {
    @Test
    void testWinnowing(){
        cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.winnowing.old.Winnowing winnowing
                = new cn.doublefloat.CDCSonCNN.projects.code_anlysis.algorithm.winnowing.old.Winnowing();
        CodesCompare cmp = new CodesCompare();
        //System.out.println(winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/C/18090241-190822.c").toString()));
        //System.out.println(winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/C/18090241-190825.c").toString()));
        System.out.println(winnowing.getSimilarity(winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/Txt/TestCode1.txt").toString()),
                winnowing.winnowUsingCharacters(TxtFileUtils.readTxtFile("codes/C/18090241-190825.c").toString())));
        System.out.println("========================================");
        System.out.println(new BigDecimal(CodesCompare.getCodesSimilarity(
                "codes/Txt/TestCode1.txt", "codes/C/18090241-190825.c"))
                .setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
    }


}
