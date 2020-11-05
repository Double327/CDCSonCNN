package cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.winnowing;

import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.configEumn.Value;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.duplicateRemovalAnlysis.CodesCompare;
import cn.doublefloat.CDCSonCNN.common.utils.code_anlysis.algorithm.utils.DelVariables;
import com.google.common.base.Splitter;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 魏荣轩
 * @date 2020/11/5 16:07
 */
public class Winnowing {

    /** 子串匹配至少与噪声阈值一样长，才能被检测到（用于过滤）*/
    private final int minDetectedLength;
    /** 滑动窗口的大小 */
    private int windowSize;

    /**
     * 初始化参数，滑动窗口大小 = minDetectedLength - noiseThreshold + 1
     *
     * @param minDetectedLength 子串能被监测到的最短长度
     * @param noiseThreshold 噪声阈值，不检测比这个值小的匹配
     */
    private Winnowing(int minDetectedLength, int noiseThreshold) {
        this.minDetectedLength = minDetectedLength;
        if (noiseThreshold > minDetectedLength) {
            throw new IllegalArgumentException("噪声阈值不能大于最小匹配保证阈值！");
        }
        this.windowSize = minDetectedLength - noiseThreshold + 1;
    }
    /**
     * 用Winnowing(8, 4)初始化
     */
    public Winnowing() {
        this(8, 4);
    }

    /**
     * 计算用空格分割的单词组成的N-Grams的数字指纹
     * /
    public Set<Integer> winnowUsingWords(String text) {
        List<Integer> nh = getHashesForNGramsOfWords(text, " ");
        return buildFingerprintSet(nh);
    }

    /**
     * 先使用给定的分隔符对给定文本进行标记，以获取单词列表。
     * 然后计算每个由单词组成的N-Grams/shingle的哈希值，存入一个列表并返回
     *
     * @param text 文本
     * @param delimiter 分隔符
     * @return N-Grams/shingle的哈希值列表
     */
    private List<Integer> getHashesForNGramsOfWords(String text, String delimiter) {
        //基于分隔符delimiter对文本text进行划分并移除结果中的空格（trimResults方法）和空字符串（omitEmptyStrings方法）
        Iterator<String> tok = Splitter.on(delimiter).trimResults()
                .omitEmptyStrings().split(text).iterator();
        List<Integer> nGrams = new ArrayList<>();
        List<String> list = new ArrayList<>();
        while (tok.hasNext()) {
            list.add(tok.next());
            if (list.size() == this.minDetectedLength) {
                nGrams.add(getHash(String.join(" ", list)));
                list.remove(0);
            }
        }
        /* 当tokens比minDetectedLength短 */
        if (nGrams.isEmpty() && list.size() > 0) {
            nGrams.add(getHash(String.join(" ", list)));
        }
        return nGrams;
    }

    /**
     * 计算由字符组成的N-Grams的数字指纹. 预处理：字母变为小写且去除空格 删除变量
     */
    public Set<Integer> winnowUsingCharacters(String text) {
        //预处理
        text = pretreatment(text);
        List<Integer> nh = getHashesForNGramsOfChars(text);
        return buildFingerprintSet(nh);
    }
    /**
     * 预处理
     */
    private String pretreatment(String text) {
        //去除标点符号String textWithoutPunctuation = text.replaceAll( "[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "");
        // 移除空白字符删除变量并将大写字母换成小写字母
        text = text.replaceAll("\\s+","").toLowerCase();
        return DelVariables.delVariables(text);
    }
    /**
     * 计算每个N-Grams（由输入文本中的字符组成）的哈希值，每个N-Grams的大小为minDetectedLength
     */
    private List<Integer> getHashesForNGramsOfChars(String text) {
        List<Integer> hashes = new ArrayList<>();
        if (text.length() < this.minDetectedLength) {
            int h = getHash(text);
            hashes.add(h);
        } else {
            for (int i=0;i<text.length() - this.minDetectedLength + 1; i++) {

                hashes.add(getHash(text.substring(i, i+this.minDetectedLength)));
            }
        }
        return hashes;
    }

    /** MD5哈希函数（可用其他hash函数替换）*/
    @SuppressWarnings("UnstableApiUsage")
    private int getHash(String token) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(token, Charset.defaultCharset());
        int h = hasher.hash().asInt();
        //返回哈希值取余10000后（mod 10000）的绝对值
        return Math.abs(h%10000);
    }

    private Set<Integer> buildFingerprintSet(List<Integer> nHash){
        Set<Integer> fp = new TreeSet<>();
        for (int i=0; i<nHash.size()-this.windowSize+1; i++) {
            List<Integer> s = new ArrayList<>(nHash.subList(i, i+this.windowSize));
            fp.add(Collections.min(s));
        }
        return fp;
    }

    /** 返回当前使用的winnowing参数值(minDetectedLength、windowSize)*/
    public HashMap getParams() {
        HashMap<String,Integer> params = new HashMap<>();
        params.put("minDetectedLength", this.minDetectedLength);
        params.put("windowSize", this.windowSize);
        return params;
    }

    /**
     * 判断与另一Winnowing Hash的相似度
     *
     * @param codeWinnowingSet winnowing hash表
     * @param otherCodeWinnowingSet 另一个winnowing hash表
     * @return 几何距离
     */
    public double getSimilarity(Set<Integer> codeWinnowingSet,Set<Integer> otherCodeWinnowingSet){
        double maxLength = Math.max(codeWinnowingSet.size(), otherCodeWinnowingSet.size()),sameCount = 0D;
        Iterator<Integer> code1Iterator = codeWinnowingSet.iterator(),
                        code2Iterator = otherCodeWinnowingSet.iterator();
        while (code1Iterator.hasNext() && code2Iterator.hasNext()){
            if(code1Iterator.next().equals(code2Iterator.next())){
                sameCount+=1;
            }
        }
        return new BigDecimal(sameCount/maxLength)
                .setScale(Value.PERCENTAGE_DECIMAL.getValue(), BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
