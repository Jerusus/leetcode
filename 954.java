import java.util.TreeMap;
import java.util.Map;

class Solution954 {
  public static void main(String[] args) {
    Solution954 s = new Solution954();
    int[] arr = new int[] { -2, -2, 1, -2, -1, 2 };
    s.canReorderDoubled(arr);
  }

  public boolean canReorderDoubled(int[] arr) {
    Map<Integer, Integer> pos = new TreeMap<>();
    Map<Integer, Integer> neg = new TreeMap<>();
    for (int i : arr) {
      if (i < 0) {
        neg.put(-i, neg.getOrDefault(-i, 0) + 1);
      } else {
        pos.put(i, pos.getOrDefault(i, 0) + 1);
      }
    }
    for (int key : pos.keySet()) {
      int times = pos.get(key);
      if (times == 0)
        continue;
      if (pos.containsKey(key * 2)) {
        int dbl = pos.get(key * 2);
        if (times > dbl)
          return false;
        if (times <= dbl)
          pos.put(key * 2, dbl - times);
      } else {
        return false;
      }
    }
    for (int key : neg.keySet()) {
      int times = neg.get(key);
      if (times == 0)
        continue;
      if (neg.containsKey(key * 2)) {
        int dbl = neg.get(key * 2);
        if (times > dbl)
          return false;
        if (times <= dbl)
          neg.put(key * 2, dbl - times);
      } else {
        return false;
      }
    }

    return true;
  }
}