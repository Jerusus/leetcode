import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  Map<String, Boolean> map = new HashMap<>();

  public boolean wordBreak(String s, List<String> wordDict) {
    if (map.containsKey(s))
      return map.get(s);
    boolean result = false;
    for (String word : wordDict) {
      if (s.equals(word)) {
        map.put(word, true);
        return true;
      }
      if (s.indexOf(word) == 0) {
        result = result || wordBreak(s.substring(word.length()), wordDict);
        map.put(s.substring(word.length()), result);
      }
    }
    map.put(s, result);
    return result;
  }
}