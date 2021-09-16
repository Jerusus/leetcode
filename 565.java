import java.util.HashSet;
import java.util.Set;

class Solution {
  public int arrayNesting(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      int count = 0;
      while (!visited.contains(cur)) {
        visited.add(cur);
        count++;
        cur = nums[cur];
      }
      max = Math.max(max, count);
    }

    return max;
  }
}