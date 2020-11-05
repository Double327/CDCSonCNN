package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.configEumn;

/**
 * @author 魏荣轩
 * @date 2020/11/5 21:59
 */
public enum Value {
    HAMMING_DISTANCE(3),
    PERCENTAGE_DECIMAL(4);

    private int value;
    Value(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
