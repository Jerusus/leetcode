class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int target = nums.length - 1;
        int jumps = 0;
        while (target != 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] + i >= target) {
                    target = i;
                    jumps++;
                    break;
                }
            }
        }
        return jumps;
    }
}