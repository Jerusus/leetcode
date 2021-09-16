class Solution {
  public int maxCount(int m, int n, int[][] ops) {
    if (ops.length == 0)
      return m * n;
    int xmin = Integer.MAX_VALUE;
    int ymin = Integer.MAX_VALUE;
    for (int[] op : ops) {
      int x = op[0];
      int y = op[1];
      xmin = Math.min(x, xmin);
      ymin = Math.min(y, ymin);
    }
    return xmin * ymin;
  }
}