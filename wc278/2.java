import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> maxScoreIndices(int[] nums) {
    int max = 0;
    List<Integer> res = new ArrayList<>();
    int zer = 0;
    int one = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zer++;
      }
    }
    max = zer;
    res.add(nums.length);
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 1) {
        one++;
      } else {
        zer--;
      }
      int cur = one + zer;
      if (cur > max) {
        max = cur;
        res = new ArrayList<>();
        res.add(i);
      } else if (cur == max) {
        res.add(i);
      }
    }
    return res;
  }
}