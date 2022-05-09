import java.util.Arrays;

class Solution {
  int[] f;

  public int fib(int n) {
    f = new int[n + 2];
    Arrays.fill(f, -1);
    f[0] = 0;
    f[1] = 1;
    return get(n);
  }

  int get(int n) {
    if (f[n] != -1) {
      return f[n];
    }
    int res = get(n - 1) + get(n - 2);
    f[n] = res;
    return res;
  }
}