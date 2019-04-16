class Solution {
    int max = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] incFirst = new int[nums.length];
        incFirst[0] = doit(nums[0]);
        incFirst[1] = doit(Math.max(nums[0], nums[1]));
        if (nums.length > 3) incFirst[2] = doit(nums[2] + nums[0]);
        int[] woFirst = new int[nums.length];
        woFirst[0] = 0;
        woFirst[1] = doit(nums[1]);
        if (nums.length > 3) woFirst[2] = doit(nums[2]);
        for (int i = 3; i < nums.length - 1; i++) {
            incFirst[i] = doit(Math.max(incFirst[i-2],incFirst[i-3]) + nums[i]);
            woFirst[i] = doit(Math.max(woFirst[i-2],woFirst[i-3]) + nums[i]);
        }
        
        // todo do last one
        int i = nums.length - 1;
        if (i >= 3) woFirst[i] = doit(Math.max(woFirst[i-2],woFirst[i-3]) + nums[i]);
        return max;
    }

    public int doit(int x) {
        max = Math.max(max, x);
        return x;
    }
}