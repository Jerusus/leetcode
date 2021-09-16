class Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int time = 0;
    int longest_time = 0;
    char result = ' ';

    for (int i = 0; i < keysPressed.length(); i++) {
      int duration = releaseTimes[i] - time;
      char c = keysPressed.charAt(i);
      if (duration > longest_time || (duration == longest_time && c > result)) {
        longest_time = duration;
        result = c;
      }
      time = releaseTimes[i];
    }

    return result;
  }
}