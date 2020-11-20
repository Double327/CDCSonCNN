package LeetCode.M10Y20.D3;

/**
 * @author 魏荣轩
 * @date 2020/10/3 22:45
 */
public class Pro11Mid {
    /**
     * 题目请查看笔记。
     * @param args 参数
     */
    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int area = 0;
        int maxArea = 0;
        while(i < j){
            if(height[i] > height[j]){
                area = height[j]*(j-i);
                j--;
            }else if(height[i] < height[j]){
                area = height[i]*(j-i);
                i++;
            }else{
                //两边高低相同，同时缩小，进而减少运算次数
                area = height[i]*(j-i);
                i++;
                j--;
            }
            if(maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }

}
