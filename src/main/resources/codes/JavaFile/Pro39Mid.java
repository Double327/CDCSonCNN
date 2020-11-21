package LeetCode.M10Y20.D6;

import java.util.*;

/**
 * @author 魏荣轩
 * @date 2020/10/6 21:53
 */
public class Pro39Mid {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     *
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [ [7],
     *   [2,2,3]]
     * 示例 2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [  [2,2,2,2],
     *   [2,3,3],
     *   [3,5] ]
     * 提示:
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     *
     * @param args 参数
     */
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args){
        int[] a = new int[]{2,3,4,6};
        long start = System.currentTimeMillis();
        System.out.println(combinationSum(a,6));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(path,candidates,target,0,0);
        return res;
    }

    private static void backtrack(List<Integer> path,int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            int rs = candidates[i] + sum;
            if(rs <= target) {
                path.add(candidates[i]);
                backtrack(path,candidates,target,rs,i);
                //回溯 减少 分叉数量，直至原点
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }
}
