import java.util.HashSet;
import java.util.Set;

class Solution {
  public int findFinalValue(int[] nums, int original) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    int result = original;
    while (set.contains(result)) {
      result *= 2;
    }
    return result;
  }
}