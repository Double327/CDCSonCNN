package LeetCode.M10Y20.D1;

/**
 * @author 魏荣轩
 * @date 2020/10/1 18:51
 */
public class Pro279Mid {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * @param args 参数
     */
    public static void main(String[] args){
        System.out.println("\n"+numSquares(15));
    }
    public static int numSquares(int n) {
        while(n % 4 == 0) {
            n /= 4;
        }
        if(n % 8 == 7) {
            return 4;
        }
        for(int i = 0 ; i * i <= n ; i ++){
            int x = n - i * i;
            if((int)Math.sqrt(x) * (int)Math.sqrt(x) == x) {
                return 1 + Math.min(i, 1);
            }
        }
        return 3;
    }
}
