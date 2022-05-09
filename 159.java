import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.length() <= 2) {
      return s.length();
    }
    Map<Character, Integer> mp = new HashMap<>();
    mp.put(s.charAt(0), 1);
    int max = 2;
    int left = 0;
    for (int i = 1; i < s.length(); i++) {
      mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
      while (mp.size() > 2) {
        char c = s.charAt(left);
        int count = mp.get(c);
        if (count == 1)
          mp.remove(c);
        else
          mp.put(c, count - 1);
        left++;
      }
      max = Math.max(max, i - left + 1);
    }
    return max;
  }
}