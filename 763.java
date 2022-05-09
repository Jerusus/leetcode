import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> partitionLabels(String s) {
    // Find the first and last indices of a letter to form intervals.
    int[] ends = new int[26];

    // Iterate through the string and populate index.
    for (int i = 0; i < s.length(); i++) {
      int letter = s.charAt(i) - 'a';
      ends[letter] = Math.max(ends[letter], i);
    }

    List<Integer> res = new ArrayList<>();
    int left = 0;
    int right = 0;
    int cur = 0;
    while (left < s.length()) {
      cur++;
      int letter = s.charAt(left) - 'a';
      right = Math.max(right, ends[letter]);
      if (left >= right) {
        res.add(cur);
        cur = 0;
        left++;
        right = left;
      } else {
        left++;
      }
    }

    return res;
  }
}