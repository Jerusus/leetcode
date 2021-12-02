import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  class Node {
    char val;
    int count;

    Node(char val) {
      this.val = val;
      this.count = 1;
    }

    void inc() {
      this.count++;
    }
  }

  public String frequencySort(String s) {
    Map<Character, Node> m = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (m.containsKey(c)) {
        m.get(c).inc();
      } else {
        m.put(c, new Node(c));
      }
    }
    List<Node> l = new ArrayList<>(m.values());
    Collections.sort(l, new Comparator<Node>() {
      @Override
      public int compare(Node a, Node b) {
        return b.count - a.count;
      }
    });
    String r = "";
    for (Node n : l) {
      for (int i = 0; i < n.count; i++) {
        r += n.val;
      }
    }
    return r;
  }
}