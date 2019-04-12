class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;
                if (dp[i - coins[j]] == -1) {
                    continue;
                }
                int count = dp[i - coins[j]] + 1;
                min = Math.min(min, count);
            }
            if (min != Integer.MAX_VALUE) dp[i] = min;
        }
        if (dp[amount] == 0) return -1;
        return dp[amount];
    }
}