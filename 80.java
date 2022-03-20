class Solution80 {
  public static void main(String[] args) {
    Solution80 s = new Solution80();
    s.removeDuplicates(new int[] { 1, 1, 1, 1, 2, 3, 3, 4 });
  }

  public int removeDuplicates(int[] nums) {
    int l = 0;
    int r = 0;
    int cur = nums[0];
    int dup = 0;
    while (r < nums.length) {
      nums[l] = nums[r];
      if (nums[r] > cur) {
        cur = nums[r];
        dup = 1;
        l++;
      } else {
        dup++;
        if (dup <= 2) {
          l++;
        }
      }
      r++;
    }
    return l;
  }
}