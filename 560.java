import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> sumToSeenCt = new HashMap<>();
    sumToSeenCt.put(0, 1);
    int cur = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      cur += nums[i]; // 1
      res += sumToSeenCt.getOrDefault(cur - k, 0);
      sumToSeenCt.put(cur, sumToSeenCt.getOrDefault(cur, 0) + 1); // 1 -> 1
    }
    return res;
  }
}