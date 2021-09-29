class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int m = 0;
    int c = 0;
    for (int i : nums) {
      if (i == 1) {
        c++;
      } else {
        m = Math.max(m, c);
        c = 0;
      }
    }
    return Math.max(m, c);
  }
}