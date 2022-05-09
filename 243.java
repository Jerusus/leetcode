import java.util.ArrayList;
import java.util.List;

class Solution {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        a.add(i);
      }
      if (wordsDict[i].equals(word2)) {
        b.add(i);
      }
    }
    for (int aa : a) {
      for (int bb : b) {
        res = Math.min(Math.abs(aa - bb), res);
      }
    }
    return res;
  }
}