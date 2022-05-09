import java.util.Arrays;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
  public int get(int index);

  public int length();
}

class Solution {
  int[] cache;

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int length = mountainArr.length();
    cache = new int[length];
    Arrays.fill(cache, -1);
    int peak = findPeak(mountainArr);
    if (getWithCache(peak, mountainArr) == target)
      return peak;
    int leftSearch = binarySearchLeft(target, mountainArr, 0, peak);
    if (leftSearch != -1) {
      return leftSearch;
    } else {
      return binarySearchRight(target, mountainArr, peak, length - 1);
    }
  }

  int findPeak(MountainArray ma) {
    int l = 0;
    int r = ma.length() - 1;
    int peak = 0;
    while (l < r) {
      int m = (l + r) / 2;
      if (getWithCache(m, ma) < getWithCache(m + 1, ma)) {
        l = m + 1;
        peak = l;
      } else {
        r = m;
      }
    }
    return peak;
  }

  // returns -1 if not found.
  int binarySearchLeft(int target, MountainArray ma, int l, int r) {
    while (l <= r) {
      int m = (l + r) / 2;
      if (getWithCache(m, ma) == target) {
        return m;
      }
      if (getWithCache(m, ma) < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return -1;
  }

  int binarySearchRight(int target, MountainArray ma, int l, int r) {
    while (l <= r) {
      int m = (l + r) / 2;
      if (getWithCache(m, ma) == target) {
        return m;
      }
      if (getWithCache(m, ma) > target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return -1;
  }

  int getWithCache(int i, MountainArray ma) {
    if (cache[i] != -1) {
      return cache[i];
    }
    int res = ma.get(i);
    cache[i] = res;
    return res;
  }
}