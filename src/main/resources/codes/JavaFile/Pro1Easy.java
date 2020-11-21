package LeetCode.M10Y20.D3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 魏荣轩
 * @date 2020/10/3 22:21
 */
public class Pro1Easy {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int a[] = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(a, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] returnSize=new int[]{-1,-1};
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                returnSize[0] = map.get(target - nums[i]);
                returnSize[1] = i;
                return returnSize;
            }
            map.put(nums[i],i);
        }
        return returnSize;
    }
}
