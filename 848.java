class Solution {
  public String shiftingLetters(String s, int[] shifts) {
    int shift = 0;
    for (int i = shifts.length - 1; i >= 0; i--) {
      shifts[i] %= 26;
      int cur = shifts[i];
      shifts[i] += shift;
      shift += cur;
    }
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int diff = c - 'a';
      diff += shifts[i];
      diff %= 26;
      c = (char) ('a' + diff);
      res += c;
    }
    return res;
  }
}