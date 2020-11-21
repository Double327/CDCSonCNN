package LeetCode.M9Y20.D26;

/**
 * @author 魏荣轩
 * @date 2020/9/26 12:01
 */
public class Pro70Easy {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 42.62% 的用户
     *
     * @param args 参数
     */
    public static void main(String[] args){
        int n=20;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        if(n == 1||n == 2){
            return n;
        }
        int a=1,b=2,t;
        for(int i=3;i <= n;i++){
            t=a;
            a=b;
            b=t+b;
        }
        return b;
    }
}
