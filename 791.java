import java.util.HashMap;
import java.util.Map;

class Solution {
  public String customSortString(String order, String str) {
    String result = "";
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    for (int i = 0; i < order.length(); i++) {
      char c = order.charAt(i);
      if (map.containsKey(c)) {
        for (int j = 0; j < map.get(c); j++) {
          result += c;
        }
        map.remove(c);
      }
    }
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      for (int j = 0; j < entry.getValue(); j++) {
        result += entry.getKey();
      }
    }

    return result;
  }
}