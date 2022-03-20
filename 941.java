class Solution {
  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    if (arr[1] < arr[0]) {
      return false;
    }
    boolean inc = true;
    int cur = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == cur) {
        return false;
      }
      if (inc) {
        if (arr[i] < cur) {
          inc = false;
        }
      } else {
        if (arr[i] > cur) {
          return false;
        }
      }
      cur = arr[i];
    }
    return !inc;
  }
}