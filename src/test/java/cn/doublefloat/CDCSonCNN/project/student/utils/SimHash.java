package cn.doublefloat.CDCSonCNN.project.student.utils;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.utils.TxtUtils;
import org.junit.jupiter.api.Test;

/**
 * @author 魏荣轩
 * @date 2020/10/16 23:09
 */
public class SimHash {

    @Test
    void testSimHash(){
        System.out.println(cn.doublefloat.CDCSonCNN.common.
                utils.code_anlysis.algorithm.simhash.SimHash.
                getSimHashDistance("这两种方案，要么时间复杂度高，要么空间复杂度复杂，能否有一种方案可以达到时空复杂度的绝佳平衡呢？答案是肯定的：\n" +
                        "\n" +
                        "我们可以把 64 位的二进制simhash签名均分成4块，每块16位。根据鸽巢原理（也称抽屉原理），如果两个签名的海明距离在 3 以内，它们必有一块完全相同。如下图所示：\n" +
                        "然后把分成的4 块中的每一个块分别作为前16位来进行查找，建倒排索引。",
                        "如此，如果样本库中存有2^34（差不多10亿）的simhash签名，则每个table返回2^(34-16)=262144个候选结果，大大减少了海明距离的计算成本。\n" +
                        "\n" +
                        "假设数据是均匀分布，16位的数据，产生的像限为2^16个，则平均每个像限分布的文档数则为2^34/2^16 = 2^(34-16)) ，四个块返回的总结果数为 4* 262144 （大概 100 万）。\n" +
                        "这样，原本需要比较10亿次，经过索引后，大概只需要处理100万次。",3));
    }
    @Test
    void testSimHashByTxt(){
        for(int i = 1; i <= 5 ;i++) {
            for(int j = i; j <= 5; j++) {
                if(i != j) {
                    System.out.println("codes/TestCode" + i + ".txt 与 codes/TestCode" + j + ".txt 海明距离为: " + cn.doublefloat.CDCSonCNN.common.
                            utils.code_anlysis.algorithm.simhash.SimHash.
                            getSimHashDistance(TxtUtils.readTxtFile("codes/TestCode" + i + ".txt").toString(),
                                    TxtUtils.readTxtFile("codes/TestCode" + j + ".txt").toString(), 3));
                }
            }
        }
    }
}
