package cn.doublefloat.CDCSonCNN.common.utils;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.configEumn.Value;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

/**
 * @author 魏荣轩
 * @date 2020/10/28 18:12
 */
class CodesCompareTest {
    @Test
    void textCompare(){
        System.out.println("codes/Txt/TestCode2.cpp 查重 codes/Cpp/TestCode1.cpp 相似度: "+
                new BigDecimal(CodesCompare.getCodesSimilarity("codes/Cpp/TestCode1.cpp", "codes/Cpp/TestCode2.cpp"))
                        .setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue()+" %");
    }

    @Test
    void testCFileCompare(){
        for(int i = 10 ; i <= 32; i++){
            for(int j = i+1 ; j<=32 ;j++){
                double same = new BigDecimal(CodesCompare.getCodesSimilarity(
                        "codes/C/18090241-1908"+i+".c", "codes/C/18090241-1908"+j+".c"))
                        .setScale(Value.PERCENTAGE_DECIMAL.getValue(), BigDecimal.ROUND_HALF_UP).doubleValue();
                if(same > 0.5) {
                    System.out.println("codes/C/18090241-1908"+i+".c & codes/C/18090241-1908"+j+".c 相似度:"+same );
                }
            }
        }
    }
}
