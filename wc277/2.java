import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[] rearrangeArray(int[] nums) {
    int size = nums.length;
    List<Integer> pos = new ArrayList<>();
    List<Integer> neg = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        pos.add(nums[i]);
      } else {
        neg.add(nums[i]);
      }
    }
    int[] res = new int[size];
    for (int i = 0; i < res.length / 2; i++) {
      res[i * 2] = pos.get(i);
      res[i * 2 + 1] = neg.get(i);
    }
    return res;
  }
}