import java.util.HashSet;
import java.util.Set;

class TwoSum {

  Set<Integer> s;
  Set<Integer> s2;

  public TwoSum() {
    s = new HashSet<>();
    s2 = new HashSet<>();
  }

  public void add(int number) {
    if (s.contains(number)) {
      s2.add(number);
    }
    s.add(number);
  }

  public boolean find(int value) {
    for (int i : s) {
      if (i * 2 == value) {
        if (s2.contains(i))
          return true;
      } else if (s.contains(value - i)) {
        return true;
      }
    }
    return false;
  }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */