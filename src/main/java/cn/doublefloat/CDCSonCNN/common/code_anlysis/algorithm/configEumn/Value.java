package cn.doublefloat.CDCSonCNN.common.code_anlysis.algorithm.configEumn;

/**
 * @author 魏荣轩
 * @date 2020/11/5 21:59
 */
public enum Value {
    /**
     * 海明距离
     * 相似度小数位余数
     */
    HAMMING_DISTANCE(3),
    PERCENTAGE_DECIMAL(6);

    private int value;
    Value(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
