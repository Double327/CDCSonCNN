package LeetCode.M10Y20.D7;

/**
 * @author 魏荣轩
 * @date 2020/10/7 20:52
 */
public class Pro75Mid {
    public static void main(String[] args){
        int[] a = new int[]{2,1};
        sortColors(a);
        for(int as : a) {
            System.out.print(as+" - ");
        }
    }
    public static void sortColors(int[] nums) {
        int indexA = -1;
        int indexB = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 2) {
                indexB++;
                swap(nums, i, indexB);
                if (nums[indexB] < 1) {
                    indexA++;
                    swap(nums, indexA, indexB);
                }
            }
        }
    }
    public static void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
