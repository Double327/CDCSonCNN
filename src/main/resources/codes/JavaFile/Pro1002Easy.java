package LeetCode.M10Y20.D14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魏荣轩
 * @date 2020/10/14 18:31
 */
public class Pro1002Easy {
    public static void main(String[] args){

    }
    public static List<String> commonChars(String[] A) {
        List<String> charList = new ArrayList<>();
        int[] checked = new int[26];
        for(char c : A[0].toCharArray()){
            checked[c-'a']++;
        }
        for(int i = 1; i<A.length; i++){
            int[] chars = new int[26];
            for(int c : A[i].toCharArray()){
                chars[c-'a']++;
            }
            for(int t=0; t<26; t++){
                checked[t] = Math.min(checked[t],chars[t]);
            }
        }
        for(int i = 0; i < checked.length ; i++){
            if(checked[i] > 0){
                for(int j = 0; j < checked[i]; j++){
                    charList.add(((char)('a' + i)+""));
                }
            }
        }
        return charList;
    }
}
