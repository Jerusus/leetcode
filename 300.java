import java.util.ArrayList;
import java.util.List;

class Solution {
  public int lengthOfLIS(int[] nums) {
    List<Integer> res = new ArrayList<>();
    res.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int cur = nums[i];
      if (cur > res.get(res.size() - 1)) {
        res.add(cur);
      } else {
        res.set(binarySearchInsert(cur, res), cur);
      }
    }
    return res.size();
  }

  public int binarySearchInsert(int cur, List<Integer> res) {
    int lo = 0;
    int hi = res.size() - 1;
    while (lo < hi) {
      int mid = (hi + lo) / 2;
      if (cur == res.get(mid)) {
        return mid;
      } else if (cur < res.get(mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}