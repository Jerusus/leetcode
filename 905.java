import java.util.Arrays;

class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int hi = nums.length - 1;
    for (int i = 0; i < hi; i++, hi--) {
      if (nums[i] % 2 == 0) {
        hi++;
        continue;
      }
      if (nums[hi] % 2 == 1) {
        i--;
        continue;
      }
      int temp = nums[hi];
      nums[hi] = nums[i];
      nums[i] = temp;
    }
    return nums;
  }
}