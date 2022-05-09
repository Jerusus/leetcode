import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      String key = "_";
      for (int i = 1; i < s.length(); i++) {
        char a = s.charAt(i - 1);
        char b = s.charAt(i);
        int diff = b - a;
        if (diff < 0) {
          diff += 26;
        }
        key += diff + "_";
      }
      if (map.containsKey(key)) {
        map.get(key).add(s);
      } else {
        List<String> l = new ArrayList<>();
        l.add(s);
        map.put(key, l);
      }
    }
    return new ArrayList<>(map.values());
  }
}