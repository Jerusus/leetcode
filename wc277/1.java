import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public int countElements(int[] nums) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i : nums) {
      if (m.containsKey(i)) {
        m.put(i, m.get(i) + 1);
      } else {
        m.put(i, 1);
      }
    }
    int result = 0;
    List<Integer> l = new ArrayList<>(m.keySet());
    Collections.sort(l);
    for (int i = 1; i < l.size() - 1; i++) {
      result += m.get(l.get(i));
    }
    return result;
  }
}