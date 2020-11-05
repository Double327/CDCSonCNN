package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.configEumn;

/**
 * @author 魏荣轩
 * @date 2020/11/5 19:16
 */
public enum Weight {
    /**
     * 权重分值
     * simHash需>=1
     */
    SIMHASH_WEIGHT(0.1),
    COMPARE_WEIGHT(0.75),
    WINNOWING_WEIGHT(0.15);
    private double weight;
    Weight(double weight){
        this.weight=weight;
    }
    public double getWeight(){
        return weight;
    }
}
