class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int target = nums.length - 1;
        int cur = nums.length - 2;
        while (cur >= 0) {
            if (nums[cur] + cur >= target) {
                target = cur;
            }
            cur--;
        }
        return target == 0;
    }
}