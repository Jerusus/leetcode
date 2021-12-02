class Solution201 {
  public static void main(String args[]) {
    Solution201 s = new Solution201();
    int n = s.rangeBitwiseAnd(8, 11);
    System.out.println(n);
  }

  public int rangeBitwiseAnd(int left, int right) {
    int count = 0;
    while (left != right) {
      if (left == 0 || right == 0) {
        return 0;
      }
      left = left >> 1;
      right = right >> 1;
      count++;
    }
    return right * (int) Math.pow(2, count);
  }
}