class NumArray {

    int[] nums;
    int[] dp;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length];
        if (nums.length != 0) dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */