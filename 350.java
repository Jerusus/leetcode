import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> res = new ArrayList<>();
    for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
      if (nums1[i] == nums2[j]) {
        res.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        i++;
      }
    }

    return res.stream().mapToInt(i -> i).toArray();
  }
}