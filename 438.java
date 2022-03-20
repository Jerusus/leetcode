import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] pmap = new int[26];
    for (int i = 0; i < p.length(); i++) {
      pmap[p.charAt(i) - 'a']++;
    }

    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int add = s.charAt(i) - 'a';
      map[add]++;
      if (i >= p.length()) {
        int remove = s.charAt(i - p.length()) - 'a';
        map[remove]--;
      }
      if (Arrays.equals(map, pmap)) {
        res.add(i - p.length() + 1);
      }
    }
    return res;
  }
}