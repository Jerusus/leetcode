class Solution838 {
  public static void main(String[] args) {
    Solution838 s = new Solution838();
    s.pushDominoes(".L.R...LR..L..");
  }

  public String pushDominoes(String dominoes) {
    int[] r_array = new int[dominoes.length()];
    boolean r_on = false;
    int r_count = 0;
    for (int i = 0; i < dominoes.length(); i++) {
      if (dominoes.charAt(i) == 'R') {
        r_on = true;
        r_array[i] = 0;
        r_count = 1;
      } else if (dominoes.charAt(i) == 'L') {
        r_on = false;
        r_array[i] = -1;
        r_count = 0;
      } else if (r_on) {
        r_array[i] = r_count;
        r_count++;
      } else {
        r_array[i] = -1;
        r_count = 0;
      }
    }
    boolean l_on = false;
    int l_count = 0;
    StringBuilder s = new StringBuilder();
    for (int i = dominoes.length() - 1; i >= 0; i--) {
      if (dominoes.charAt(i) == 'L') {
        s.append('L');
        l_on = true;
        l_count = 1;
      } else if (dominoes.charAt(i) == 'R') {
        s.append('R');
        l_on = false;
        l_count = 0;
      } else if (l_on) {
        if (r_array[i] == l_count) {
          s.append('.');
        } else if (r_array[i] < 0 || r_array[i] > l_count) {
          s.append('L');
        } else {
          s.append('R');
        }
        l_count++;
      } else {
        if (r_array[i] >= 0) {
          s.append('R');
        } else {
          s.append('.');
        }
        l_count = 0;
      }
    }

    return s.reverse().toString();
  }
}
