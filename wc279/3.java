import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Bitset {
  int size = 0;
  Set<Integer> set;
  boolean flipped;

  public Bitset(int size) {
    this.size = size;
    this.set = new HashSet<>();
    this.flipped = false;
  }

  public void fix(int idx) {
    if (flipped) {
      set.remove(idx);
    } else
      set.add(idx);
  }

  public void unfix(int idx) {
    if (flipped) {
      set.add(idx);
    } else
      set.remove(idx);
  }

  public void flip() {
    flipped = !flipped;
  }

  public boolean all() {
    if (flipped) {
      return set.isEmpty();
    } else {
      return set.size() == size;
    }
  }

  public boolean one() {
    if (flipped) {
      return set.size() != size;
    } else {
      return !set.isEmpty();
    }
  }

  public int count() {
    if (flipped) {
      return size - set.size();
    } else {
      return set.size();
    }
  }

  public String toString() {
    char c;
    char d;
    if (flipped) {
      c = '1';
      d = '0';
    } else {
      c = '0';
      d = '1';
    }
    char[] res = new char[size];
    Arrays.fill(res, c);
    for (int i : set) {
      res[i] = d;
    }
    return new String(res);
  }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */