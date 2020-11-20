package LeetCode.M9Y20.D27;

/**
 * @author 魏荣轩
 * @date 2020/9/27 21:03
 */
public class Pro136Easy {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param args
     */
    public static void main(String[] args){
        int n=20;
        System.out.println();
    }
    public static int singleNumber(int[] nums) {
        int singleNum = nums[0];
        for(int i=1;i<nums.length;i++){
            singleNum = singleNum ^ nums[i];
        }
        return singleNum;
    }
}
