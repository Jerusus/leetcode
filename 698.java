import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution698 {
  public static void main(String args[]) {
    Solution698 s = new Solution698();
    int[] nums = new int[] { 4, 3, 2, 3, 5, 2, 1 };
    s.canPartitionKSubsets(nums, 4);
  }

  public boolean canPartitionKSubsets(int[] nums, int k) {
    // first, subset must equal total / k.
    // can't do greedy
    int total = 0;
    int max = 0;
    for (int num : nums) {
      total += num;
      if (num > max)
        max = num;
    }
    if (total % k != 0 || max > total / k)
      return false;
    int target = total / k;
    Arrays.sort(nums);
    nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

    Set<Integer> used = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (used.contains(i))
        continue;
      Set<Integer> temp_used = new HashSet<>(used);
      temp_used.add(i);
      boolean found = find(cur, target, i, nums, temp_used);
      if (!found)
        return false;
      used.addAll(temp_used);
    }

    return true;
  }

  public boolean find(int cur, int target, int index, int[] nums, Set<Integer> used) {
    if (cur == target) {
      return true;
    }
    for (int i = index + 1; i < nums.length; i++) {
      if (used.contains(i)) {
        continue;
      }
      if (cur + nums[i] <= target) {
        used.add(i);
        boolean found = find(cur + nums[i], target, i, nums, used);
        if (!found) {
          used.remove(i);
        } else {
          return true;
        }
      }
    }
    return false;
  }
}