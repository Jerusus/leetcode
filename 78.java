import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void permute(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        res.add(cur);
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> copy = new ArrayList<>(cur);
            cur.add(nums[i]);
            permute(res, copy, nums, i+1);
        }
        return;
    }
}