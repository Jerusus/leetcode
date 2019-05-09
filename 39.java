import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, candidates, candidates.length - 1, 0, target, new ArrayList<Integer>());
        return res;
    }
    private void permute(List<List<Integer>> list, int[] candidates, int limit, int sum, int target, List<Integer> cur) {
        if (sum == target) {
            list.add(cur);
            return;
        } else if (sum > target) return;
        for (int i = limit; i >= 0; i--) {
            List<Integer> dest = new ArrayList<>(cur);
            dest.add(candidates[i]);
            permute(list, candidates, i, sum + candidates[i], target, dest);
        }
        return;
    }
}