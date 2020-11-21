package LeetCode.M9Y20.D28;

/**
 * @author 魏荣轩
 * @date 2020/9/28 22:35
 */
public class Pro198Easy {
    public static void main(String[] args){
        int[] house = new int[]{2,7,9,3,1};
        System.out.println(rob(house));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        if (len==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] DP = new int[len];
        DP[0]=nums[0];
        DP[1]=Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++){
            DP[i] = Math.max(nums[i]+DP[i-2],DP[i-1]);
        }
        return DP[DP.length-1];
    }
}
