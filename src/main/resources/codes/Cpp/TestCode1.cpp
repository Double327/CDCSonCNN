public class Pro39Mid {

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
