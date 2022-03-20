import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> findLonely(int[] nums) {
    List<Integer> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if ((i == 0 || nums[i] - nums[i - 1] > 1) && (i == nums.length - 1 || nums[i + 1] - nums[i] > 1)) {
        res.add(nums[i]);
      }
    }

    return res;
  }
}