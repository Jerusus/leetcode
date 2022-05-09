// incorrect
class Solution {
  int res = 0;

  public int minScoreTriangulation(int[] values) {
    tri(values);

    return res;
  }

  void tri(int[] values) {
    if (values.length == 3) {
      res += values[0] * values[1] * values[2];
      return;
    }
    // find smallest vertex
    int min = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < values.length; i++) {
      if (values[i] < min) {
        min = values[i];
        index = i;
      }
    }
    // find smallest other vertex
    min = Integer.MAX_VALUE;
    int index2 = -1;
    for (int i = 0; i < values.length; i++) {
      if (i == index || ((i + 1) % values.length) == index || (((i - 1 + values.length) % values.length) == index)) {
        continue;
      }
      if (values[i] < min) {
        min = values[i];
        index2 = i;
      }
    }

    // make index2 the higher val.
    if (index2 < index) {
      int temp = index;
      index = index2;
      index2 = temp;
    }

    int[] a = new int[index2 - index + 1];
    for (int i = index; i <= index2; i++) {
      a[i - index] = values[i];
    }
    tri(a);

    int[] b = new int[values.length - (index2 - index) + 1];
    for (int i = index2; i <= index + values.length; i++) {
      b[i - index2] = values[i % values.length];
    }
    tri(b);
  }
}