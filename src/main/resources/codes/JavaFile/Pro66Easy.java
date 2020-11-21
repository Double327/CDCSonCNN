package LeetCode.M9Y20.D25;

import sun.java2d.windows.GDIWindowSurfaceData;

import java.util.Arrays;

/**
 * @author 魏荣轩
 * @date 2020/9/25 19:40
 */
public class Pro66Easy {
    /**
     * Pro:
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int[] a = new int[]{2,9,6,9,9};
        System.out.println(Arrays.toString(plusOne(a)));
    }
    public static int[] plusOne(int[] digits) {
        for(int len=digits.length-1;len>0;len--){
            if(digits[len] != 9){
                digits[len]++;
                return digits;
            }
            //为9，进位，本位设为0,并再次循环，开始判断上一位.
            digits[len] = 0;
        }
        //出循环即代表所有位数均为9.
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
