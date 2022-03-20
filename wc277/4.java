package wc277;

import java.util.HashSet;
import java.util.Set;

class Solution4 {
  public static void main(String args[]) {
    int[][] s = new int[][] { { 2, 2, 2, 2 }, { 1, 2, 1, 0 }, { 0, 2, 2, 2 }, { 0, 0, 0, 2 } };
    Solution4 ss = new Solution4();
    ss.maximumGood(s);
  }

  public int maximumGood(int[][] statements) {
    Set<Integer> good = new HashSet<>();
    good.add(0);
    Set<Integer> bad = new HashSet<>();
    bad.add(0);
    return Math.max(recurse(statements, 0, good, new HashSet<>(), 0), recurse(statements, 0, new HashSet<>(), bad, 0));
  }

  int recurse(int[][] statements, int cur, Set<Integer> good, Set<Integer> bad, int count) {
    if (cur >= statements.length) {
      return count;
    }
    if (good.contains(cur) && bad.contains(cur)) {
      return 0;
    }
    if (!good.contains(cur) || bad.contains(cur)) {
      Set<Integer> newgood = new HashSet<>(good);
      newgood.add(cur + 1);
      Set<Integer> newbad = new HashSet<>(bad);
      newbad.add(cur + 1);
      return Math.max(recurse(statements, cur + 1, new HashSet<>(newgood), new HashSet<>(bad), count),
          recurse(statements, cur + 1, new HashSet<>(good), new HashSet<>(newbad), count));
    } else {
      for (int i = 0; i < statements.length; i++) {
        if (statements[cur][i] == 0) {
          if (good.contains(i)) {
            return 0;
          }
          bad.add(i);
        } else if (statements[cur][i] == 1) {
          if (bad.contains(i)) {
            return 0;
          }
          good.add(i);
        }
      }
      Set<Integer> newgood = new HashSet<>(good);
      newgood.add(cur + 1);
      Set<Integer> newbad = new HashSet<>(bad);
      newbad.add(cur + 1);
      return Math.max(recurse(statements, cur + 1, new HashSet<>(newgood), new HashSet<>(bad), count + 1),
          recurse(statements, cur + 1, new HashSet<>(good), new HashSet<>(newbad), count + 1));
    }
  }
}