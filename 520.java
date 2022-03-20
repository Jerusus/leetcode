class Solution {
  public boolean detectCapitalUse(String word) {
    return word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())
        || word.equals(String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase());
  }
}