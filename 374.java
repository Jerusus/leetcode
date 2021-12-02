class Solution374 {
  public static void main(String[] args) {
    Solution374 s = new Solution374();
    s.guessNumber(2126753390);
  }

  public int guessNumber(int n) {
    return guessNumber(1, n);
  }

  public int guessNumber(int lo, int hi) {
    while (lo < hi) {
      int n = lo + (hi - lo) / 2;
      if (guess(n) > 0) {
        lo = n + 1;
      } else {
        hi = n;
      }
    }
    return lo;
  }

  public int guess(int n) {
    int v = 1702766719;
    if (n == v)
      return 0;
    if (n < v)
      return -1;
    return 1;
  }
}