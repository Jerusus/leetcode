class Solution {
  public int uniquePaths(int m, int n) {
    int[][] res = new int[m][n];
    res[m - 1][n - 1] = 1;
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1)
          continue;
        int paths = 0;
        if (i + 1 < m)
          paths += res[i + 1][j];
        if (j + 1 < n)
          paths += res[i][j + 1];
        res[i][j] = paths;
      }
    }

    return res[0][0];
  }
}