class Solution {
  public boolean backspaceCompare(String s, String t) {
    int a = s.length() - 1;
    int b = t.length() - 1;
    int s_count = 0;
    int t_count = 0;
    while (a >= 0 || b >= 0) {
      while (a >= 0 && (s.charAt(a) == '#' || s_count > 0)) {
        if (s.charAt(a) == '#') {
          s_count++;
        } else {
          s_count--;
        }
        a--;
      }
      while (b >= 0 && (t.charAt(b) == '#' || t_count > 0)) {
        if (t.charAt(b) == '#') {
          t_count++;
        } else {
          t_count--;
        }
        b--;
      }
      if (a >= 0 && b < 0 || a < 0 && b >= 0) {
        return false;
      }
      if (a >= 0 && b >= 0) {
        if (s.charAt(a) != t.charAt(b)) {
          return false;
        }
        a--;
        b--;
      }
    }
    return true;
  }
}