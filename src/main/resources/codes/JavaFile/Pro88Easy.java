package LeetCode.M9Y20.D26;

/**
 * @author 魏荣轩
 * @date 2020/9/26 12:21
 */
public class Pro88Easy {
    /**
     *给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     *执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *内存消耗： 39.1 MB , 在所有 Java 提交中击败了 24.72% 的用户
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5,0,0,0,0,0},b = new int[]{2,6,8,9,15};
        merge(a,a.length-b.length,b,b.length);
        for(int a1:a){
            System.out.print(a1+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //获得总长度的最后一个下标
        int len = m-- + n-- -1;
        while (m >= 0 && n >= 0){
            nums1[len--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0){
            nums1[len--] = nums2[n--];
        }
    }
}
