package LeetCode.M9Y20.D29;

import java.util.Arrays;

/**
 * @author 魏荣轩
 * @date 2020/9/29 22:04
 */
public class Pro242Easy {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * @param args 参数
     */
    public static void main(String[] args){
        System.out.println(isAnagram("a","b"));
    }
    public static boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i = 0;i < arrayS.length; i++){
            a[arrayS[i]-'a']++;
            a[arrayT[i]-'a']--;
        }
        for(int a1:a){
            if(a1!=0){
                return false;
            }
        }
        return true;
    }
}
