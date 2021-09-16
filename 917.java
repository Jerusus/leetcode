class Solution {
  public String reverseOnlyLetters(String s) {
    StringBuilder sb = new StringBuilder();
    int j = s.length() - 1;
    for (int i = 0; i < s.length(); i++) {
      while (j >= 0 && !isLetter(s.charAt(j))) {
        j--;
      }
      if (isLetter(s.charAt(i))) {
        sb.append(s.charAt(j));
        j--;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  boolean isLetter(char c) {
    return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
  }
}