class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0]+nums[2], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];
        int max = Math.max(dp[2],dp[1]);
        int currentStep = 3;
        while (currentStep < nums.length) {
            int one = dp[currentStep - 2] + nums[currentStep];
            int two = dp[currentStep - 3] + nums[currentStep];
            dp[currentStep] = Math.max(one, two);
            max = Math.max(max, dp[currentStep]);
            currentStep++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
    }
}
