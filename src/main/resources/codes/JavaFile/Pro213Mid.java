package LeetCode.M9Y20.D28;

/**
 * @author 魏荣轩
 * @date 2020/9/28 22:00
 */
public class Pro213Mid {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 示例 2:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int[] house = new int[]{1,2,3,1,7,9,1,6,8};
        System.out.print(rob(house));
    }
    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dpone = new int[nums.length];
        int[] dptwo = new int[nums.length];
        dpone[0] = nums[0];
        dpone[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length -1;i++){
            dpone[i] = Math.max(nums[i]+dpone[i-2],dpone[i-1]);
        }
        dptwo[1] = nums[1];
        dptwo[2] = Math.max(nums[1],nums[2]);
        for(int i = 3;i < nums.length;i++){
            dptwo[i] = Math.max(nums[i] + dptwo[i-2],dptwo[i-1]);
        }
        return Math.max(dpone[nums.length-2],dptwo[nums.length-1]);
    }
}
