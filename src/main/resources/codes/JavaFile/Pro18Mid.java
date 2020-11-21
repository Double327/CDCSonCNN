package LeetCode.M10Y20.D5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 魏荣轩
 * @date 2020/10/5 22:22
 */
public class Pro18Mid {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [ [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2] ]
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        for(List<Integer> numsList : fourSum(a,0)){
            for(int num : numsList){
                System.out.print(" "+num);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>() ;
        if(nums.length<4) {
            return res;
        }
        int indexA,indexB,indexC,indexD,len = nums.length;
        for(indexA=0;indexA<=len-4;indexA++){
            if(indexA>0&&nums[indexA]==nums[indexA-1]){
                continue;
            }
            for(indexB=indexA+1;indexB<=len-3;indexB++){
                if(indexB>indexA+1&&nums[indexB]==nums[indexB-1]){
                    continue;
                }
                indexC=indexB+1;
                indexD=len-1;
                while (indexC<indexD){
                    if(nums[indexA]+nums[indexB]+nums[indexC]+nums[indexD]<target){
                        //小于目标值，将内嵌套指针左端右移一位
                        indexC++;
                    }else if (nums[indexA]+nums[indexB]+nums[indexC]+nums[indexD]>target){
                        //大于目标值，将内嵌套指针右端左移一位
                        indexD--;
                    }else {
                        List<Integer> nowIndex = new ArrayList<Integer>();
                        nowIndex.add(nums[indexA]);
                        nowIndex.add(nums[indexB]);
                        nowIndex.add(nums[indexC]);
                        nowIndex.add(nums[indexD]);
                        res.add(nowIndex);
                        //确保 nums[indexC] 改变
                        while(indexC < indexD && nums[indexC+1] == nums[indexC]){
                            indexC++;
                        }
                        while(indexC < indexD && nums[indexD-1] == nums[indexD]){
                            indexD--;
                        }
                        indexC++;
                        indexD--;
                    }

                }
            }
        }
        return res;
    }
}
