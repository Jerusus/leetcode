import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> m = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      m.put(list1[i], i);
    }
    int min = Integer.MAX_VALUE;
    List<String> res = new ArrayList<>();
    for (int i = 0; i < list2.length; i++) {
      if (i > min) {
        break;
      }
      String s = list2[i];
      if (m.containsKey(s)) {
        int val = m.get(s) + i;
        if (val < min) {
          min = val;
          res = new ArrayList<>();
          res.add(s);
        } else if (val == min) {
          res.add(s);
        }
      }
    }
    return res.toArray(new String[res.size()]);
  }
}