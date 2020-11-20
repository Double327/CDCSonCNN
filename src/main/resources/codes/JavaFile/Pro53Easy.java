package LeetCode.M9Y20.D25;

/**
 * @author 魏荣轩
 * @date 2020/9/25 19:25
 */
public class Pro53Easy {
    /**
     * Pro:
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * 结果：
     * 执行结果： 通过
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.96% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 7.24% 的用户
     */
    public static void main(String[] args){
        int[] a=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int[] nums) {
        int indexNum=nums[0];
        int sum=0;
        for(int num:nums){
            if(sum>0) {
                sum += num;
            }else {
                sum = num;
            }
            indexNum = Math.max(indexNum,sum);
        }
        return indexNum;
    }
}
