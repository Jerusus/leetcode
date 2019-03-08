class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int currentStep = 2;
        while (currentStep < cost.length) {
            int one = dp[currentStep - 1] + cost[currentStep];
            int two = dp[currentStep - 2] + cost[currentStep];
            dp[currentStep] = Math.min(one, two);
            currentStep++;
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
