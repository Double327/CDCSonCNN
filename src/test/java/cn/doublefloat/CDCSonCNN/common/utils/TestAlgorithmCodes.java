package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.AlgorithmCodes;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.utils.TxtFileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 魏荣轩
 * @date 2020/11/5 22:04
 */
public class TestAlgorithmCodes {
    @Test
    void testAlgorithmCodes(){
        AlgorithmCodes algorithmCodes = new AlgorithmCodes();
        System.out.println("Similarity: "+(algorithmCodes.simWinCompareSimilarity("codes/C/18090241-190824.c"
                ,"codes/C/18090241-190825.c")*100) +"%");
    }
}
