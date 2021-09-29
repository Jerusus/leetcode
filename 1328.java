class Solution {
  public String breakPalindrome(String palindrome) {
    if (palindrome.length() < 2) {
      return "";
    }
    char[] c = palindrome.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (c[i] != 'a' && (i != c.length / 2 || c.length % 2 == 0)) {
        c[i] = 'a';
        return new String(c);
      }
    }
    c[c.length - 1] = 'b';
    return new String(c);
  }
}