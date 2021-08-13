import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();

    Map<String, List<String>> m = new HashMap<>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String sorted = new String(arr);
      if (m.containsKey(sorted)) {
        m.get(sorted).add(s);
      } else {
        List<String> l = new ArrayList<>();
        l.add(s);
        m.put(sorted, l);
      }
    }

    for (List<String> l : m.values()) {
      res.add(l);
    }

    return res;
  }
}