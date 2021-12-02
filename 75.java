class Solution {
  public void sortColors(int[] nums) {
    int a = 0, b = 0, c = 0;
    for (int i = 0; i < nums.length; i++) {
      int v = nums[i];
      if (v == 0)
        a++;
      if (v == 1)
        b++;
      if (v == 2)
        c++;
    }

    for (int i = 0; i < a; i++)
      nums[i] = 0;
    for (int i = 0; i < b; i++)
      nums[i + a] = 1;
    for (int i = 0; i < c; i++)
      nums[i + a + b] = 2;
  }
}