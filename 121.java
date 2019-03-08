class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] change = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++) {
            change[i-1] = prices[i] - prices[i-1];
        }
        int[] dp = new int[change.length];
        dp[0] = Math.max(0, change[0]);
        int max = Math.max(0, dp[0]);
        for (int i = 1; i < change.length; i++) {
            dp[i] = dp[i-1] + change[i] > 0 ? dp[i-1] + change[i] : Math.max(change[i], 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
