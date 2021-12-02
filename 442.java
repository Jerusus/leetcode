import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int[] r = new int[100001];
    for (int n : nums) {
      if (r[n] == 1) {
        res.add(n);
      } else {
        r[n] = 1;
      }
    }
    return res;
  }
}