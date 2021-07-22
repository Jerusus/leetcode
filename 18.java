import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> res = new HashSet<>();
    Arrays.sort(nums);
    Map<Integer, List<Bi>> map = new TreeMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        Bi b = new Bi(i, j);
        if (map.containsKey(sum)) {
          map.get(sum).add(b);
        } else {
          List<Bi> a = new ArrayList<>();
          a.add(b);
          map.put(sum, a);
        }
      }
    }

    // go up to half of the target
    for (int a : map.keySet()) {
      if (a > target / 2) {
        break;
      }
      int b = target - a;
      if (map.containsKey(b)) {
        List<Bi> indices_a = map.get(a);
        List<Bi> indices_b = map.get(b);
        for (Bi aa : indices_a) {
          for (Bi bb : indices_b) {
            if (!aa.con(bb)) {
              List<Integer> hit = new ArrayList<>();
              hit.add(nums[aa.a]);
              hit.add(nums[aa.b]);
              hit.add(nums[bb.a]);
              hit.add(nums[bb.b]);
              Collections.sort(hit);
              res.add(hit);
            }
          }
        }
      }
    }
    return new ArrayList<>(res);
  }
}

class Bi {
  int a;
  int b;

  Bi(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public boolean con(Bi o) {
    return this.a == o.a || this.a == o.b || this.b == o.a || this.b == o.b;
  }
}
