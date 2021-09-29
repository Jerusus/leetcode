import java.util.Arrays;

class Solution {
  int[] dp = new int[38];

  public int tribonacci(int n) {
    Arrays.fill(dp, -1);
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    return trib(n, dp);
  }

  public int trib(int n, int[] dp) {
    if (dp[n] != -1) {
      return dp[n];
    }
    int res = trib(n - 1, dp) + trib(n - 2, dp) + trib(n - 3, dp);
    dp[n] = res;
    return res;
  }
}