class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        recurse(nums, S, 0, 0);
        return res;
    }
    public void recurse(int[] nums, int S, int index, int current) {
        if (index == nums.length) {
            if (S == current) res++;
            return;
        }
        recurse(nums, S, index+1, current + nums[index]);
        recurse(nums, S, index+1, current - nums[index]);
    }
}