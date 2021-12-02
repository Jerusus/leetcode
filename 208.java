import java.util.HashMap;
import java.util.Map;

public class Node {
  String val;
  Map<Character, Node> dict;

  public Node() {
    this.val = null;
    this.dict = new HashMap<>();
  }

  public Node(String val) {
    this.val = val;
    this.dict = new HashMap<>();
  }
}

class Trie {
  class Node {
    String val;
    Map<Character, Node> dict;

    public Node() {
      this.val = null;
      this.dict = new HashMap<>();
    }

    public Node(String val) {
      this.val = val;
      this.dict = new HashMap<>();
    }
  }

  Node head;

  public Trie() {
    head = new Node();
  }

  public void insert(String word) {
    Node cur = this.head;
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      if (cur.dict.containsKey(c)) {
        cur = cur.dict.get(c);
      } else {
        Node n = new Node();
        cur.dict.put(c, n);
        cur = n;
      }
    }
    cur.val = word;
  }

  public boolean search(String word) {
    Node cur = this.head;
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      if (!cur.dict.containsKey(c)) {
        return false;
      }
      cur = cur.dict.get(c);
    }
    return cur.val != null && cur.val.equals(word);
  }

  public boolean startsWith(String prefix) {
    Node cur = this.head;
    for (int i = 0; i < prefix.length(); i++) {
      Character c = prefix.charAt(i);
      if (!cur.dict.containsKey(c)) {
        return false;
      }
      cur = cur.dict.get(c);
    }
    return true;
  }
}