class Solution978 {
  public static void main(String args[]) {
    Solution978 s = new Solution978();
    s.maxTurbulenceSize(new int[] { 2, 0, 2, 4, 2, 5, 0, 1, 2, 3 });
  }

  public int maxTurbulenceSize(int[] arr) {
    if (arr.length == 0 || arr.length == 1)
      return arr.length;
    int max = 1;
    // 0 same, 1 got bigger, -1 got smaller.
    int status = 0;
    int prev_val = arr[0];
    int cur_len = 1;
    for (int i = 1; i < arr.length; i++) {
      if (prev_val == arr[i]) {
        status = 0;
        max = Math.max(max, cur_len);
        cur_len = 1;
      } else if (prev_val < arr[i]) {
        if (status == -1) {
          cur_len++;
        } else {
          max = Math.max(max, cur_len);
          cur_len = 2;
        }
        status = 1;
      } else {
        if (status == 1) {
          cur_len++;
        } else {
          max = Math.max(max, cur_len);
          cur_len = 2;
        }
        status = -1;
      }
      prev_val = arr[i];
    }
    return Math.max(max, cur_len);
  }
}