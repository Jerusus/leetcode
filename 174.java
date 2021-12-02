import java.util.Arrays;

class Solution174 {
  public static void main(String[] args) {
    Solution174 s = new Solution174();
    int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
    s.calculateMinimumHP(dungeon);
  }

  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] dp = new int[m][n];
    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }
    dp[m - 1][n - 1] = Math.abs(Math.min(dungeon[m - 1][n - 1], 0)) + 1;
    calc(dp, 0, 0, dungeon);

    return dp[0][0];
  }

  public void calc(int[][] dp, int i, int j, int[][] dungeon) {
    if (dp[i][j] != -1) {
      return;
    }
    int r = getVal(dp, i, j + 1, dungeon);
    int d = getVal(dp, i + 1, j, dungeon);
    if (r == -1 && d == -1) {
      dp[i][j] = -1;
      return;
    }
    int val;
    if (r == -1) {
      val = d;
    } else if (d == -1) {
      val = r;
    } else {
      val = Math.min(d, r);
    }
    dp[i][j] = Math.max(val - dungeon[i][j], 1);
  }

  public int getVal(int[][] dp, int i, int j, int[][] d) {
    if (i >= d.length || j >= d[0].length) {
      return -1;
    }
    if (dp[i][j] == -1) {
      calc(dp, i, j, d);
    }
    return dp[i][j];
  }
}