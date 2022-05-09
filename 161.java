class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int lengthDiff = Math.abs(s.length() - t.length());
    if (lengthDiff > 1 || s.equals(t))
      return false;
    else if (lengthDiff == 1) {
      // check for insert or delete
      boolean foundEdit = false;
      // make s the longer string
      if (t.length() > s.length()) {
        String temp = s;
        s = t;
        t = temp;
      }
      for (int i = 0, j = 0; j < t.length(); i++, j++) {
        if (s.charAt(i) != t.charAt(j)) {
          if (foundEdit) {
            return false;
          } else {
            foundEdit = true;
            j--;
          }
        }
      }
    } else {
      // check for replace
      boolean foundReplace = false;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          if (foundReplace) {
            return false;
          } else {
            foundReplace = true;
          }
        }
      }
    }
    return true;
  }
}