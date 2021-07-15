class Solution {
  public String longestDupSubstring(String S) {
    String longest = "";
    for (int i = 1; i < S.length(); i++) {
      String candidate = "";
      for (int a = 0, b = i; b < S.length(); a++, b++) {
        if (S.charAt(a) == S.charAt(b)) {
          candidate += S.charAt(a);
        } else {
          if (candidate.length() > longest.length()) {
            longest = candidate;
          }
          candidate = "";
        }
      }
      if (candidate.length() > longest.length()) {
        longest = candidate;
      }
    }
    return longest;
  }
}
