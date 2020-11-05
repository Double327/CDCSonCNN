package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.simhash;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.utils.DelVariables;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 魏荣轩
 * @date 2020/10/16 22:27
 * 注: 查重过程： SimHash判断海明距离，<=3 进行词法分析生成分析文件，对分析文件进行SimHash判断，<=3 进行CNN查重;
 */
public class SimHash {
    private String tokens;
    private BigInteger intSimHash;
    private String strSimHash;
    private int hashBits = 64;

    /**
     * 构造方法
     *
     * @param tokens 字符串
     */
    public SimHash(String tokens) {
        this.tokens = tokens;
        this.intSimHash = this.simHash();
    }

    /**
     * 构造方法
     *
     * @param tokens 字符串
     * @param hashBits 哈希串
     */
    private SimHash(String tokens, int hashBits) {
        this.tokens = tokens;
        this.hashBits = hashBits;
        this.intSimHash = this.simHash();
    }

    /**
     * 获取SimHash值
     *
     * @return 二进制simHash值
     */
    private BigInteger simHash() {
        int[] v = new int[this.hashBits];
        StringTokenizer stringTokens = new StringTokenizer(this.tokens);
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            BigInteger t = this.hash(temp);
            for (int i = 0; i < this.hashBits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                if (t.and(bitmask).signum() != 0) {
                    v[i] += 1;
                } else {
                    v[i] -= 1;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        StringBuilder simHashBuilder = new StringBuilder();
        for (int i = 0; i < this.hashBits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
                simHashBuilder.append("1");
            }else{
                simHashBuilder.append("0");
            }
        }
        this.strSimHash = simHashBuilder.toString();
        return fingerprint;
    }

    /**
     * 获取哈希值
     *
     * @param source 源字符串
     * @return 二进制哈希值
     */
    private BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashBits).subtract(
                    new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    /**
     * 取两个二进制的异或，统计为1的个数，就是海明距离
     *
     * @return 操作次数
     */
    private int hammingDistance(SimHash other) {
        BigInteger x = this.intSimHash.xor(other.intSimHash);
        int tot = 0;
        //统计x中二进制位数为1的个数
        //一个二进制数减去1，那么，从最后那个1（包括那个1）后面的数字全都反了，后，n&(n-1)就相当于把后面的数字清0，
        //返回n能做多少次该操作
        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }

    /**
     * calculate Hamming Distance between two strings
     *  二进制怕有错，当成字符串，作一个，比较下结果
     * @param str1 the 1st string
     * @param str2 the 2nd string
     * @return 字符串1 2的海明距离
     */
    private int getDistance(String str1, String str2) {
        int distance;
        if (str1.length() != str2.length()) {
            distance = -1;
        } else {
            distance = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    /**
     * 如果海明距离取3，则分成四块，并得到每一块的bigInteger值 ，作为索引值使用
     * @param simHash SimHash数据
     * @param distance 海明距离
     * @return 分块信息
     */
    private List<BigInteger> subByDistance(SimHash simHash, int distance){
        int numEach = this.hashBits /(distance+1);
        List<BigInteger> characters = new ArrayList<BigInteger>();
        StringBuilder buffer = new StringBuilder();
        int k = 0;
        for( int i = 0; i < this.intSimHash.bitLength(); i++){
            boolean sr = simHash.intSimHash.testBit(i);
            if(sr){
                buffer.append("1");
            }
            else{
                buffer.append("0");
            }
            if( (i+1)%numEach == 0 ){
                BigInteger eachValue = new BigInteger(buffer.toString(),2);
                buffer.delete(0, buffer.length());
                characters.add(eachValue);
            }
        }
        return characters;
    }

    /**
     * 获取两字符间的海明距离
     *
     * @param str1 文本1
     * @param str2 文本2
     * @param distance 分块
     * @return SimHash
     */
    public static int getSimHashDistance(String str1,String str2,int distance){
        SimHash str1SimHash = new SimHash(DelVariables.delVariables(str1),64);
        SimHash str2SimHash = new SimHash(DelVariables.delVariables(str2),64);
        return str1SimHash.getDistance(str1SimHash.strSimHash,str2SimHash.strSimHash);
    }
}
