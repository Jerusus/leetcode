class Solution {
  public int maxNumberOfBalloons(String text) {
    int b = 0, a = 0, l = 0, o = 0, n = 0;
    for (char c : text.toCharArray()) {
      switch (c) {
        case 'b':
          b++;
          break;
        case 'a':
          a++;
          break;
        case 'l':
          l++;
          break;
        case 'o':
          o++;
          break;
        case 'n':
          n++;
          break;
        default:
          break;
      }
    }
    int result = Math.min(b, a);
    result = Math.min(result, l / 2);
    result = Math.min(result, o / 2);
    result = Math.min(result, n);
    return result;
  }
}