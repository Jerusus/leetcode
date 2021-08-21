class Solution42 {

  public static void main(String args[]) {
    Solution42 s = new Solution42();
    int[] height = new int[] { 4, 3, 3, 9, 3, 0, 9, 2, 8, 3 };
    s.trap(height);
  }

  public int trap(int[] height) {
    int res = 0;

    boolean overlap = false;
    int highest_trap = 0;
    int max = 0;
    int potential = 0;
    for (int i = 0; i < height.length; i++) {
      int cur = height[i];
      if (cur >= max) {
        res += potential;
        potential = 0;
        highest_trap = max;
        max = cur;
      } else {
        potential += max - cur;
      }
    }
    if (res > 0 && max == highest_trap) {
      overlap = true;
    }

    max = 0;
    potential = 0;
    for (int i = height.length - 1; i >= 0; i--) {
      int cur = height[i];
      if (cur >= highest_trap && overlap) {
        res += potential;
        break;
      }
      if (cur >= max) {
        res += potential;
        potential = 0;
        max = cur;
      } else {
        potential += max - cur;
      }
    }

    return res;
  }
}
