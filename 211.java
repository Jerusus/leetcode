import java.util.HashMap;
import java.util.Map;

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

class WordDictionary {

  Node head;

  public WordDictionary() {
    head = new Node();
  }

  public void addWord(String word) {
    Node cur = head;
    for (int i = 0; i < word.length(); i++) {
      if (cur.dict.containsKey(word.charAt(i))) {
        cur = cur.dict.get(word.charAt(i));
      } else {
        Node next = new Node();
        cur.dict.put(word.charAt(i), next);
        cur = next;
      }
    }
    cur.val = word;
  }

  public boolean search(String word) {
    return search(word, 0, head);
  }

  public boolean search(String substring, int i, Node root) {
    if (substring.length() == i) {
      return root.val != null;
    }
    if (substring.charAt(i) == '.') {
      for (Character c : root.dict.keySet()) {
        if (search(substring, i + 1, root.dict.get(c))) {
          return true;
        }
      }
      return false;
    } else {
      if (!root.dict.containsKey(substring.charAt(i))) {
        return false;
      } else {
        return search(substring, i + 1, root.dict.get(substring.charAt(i)));
      }
    }
  }
}
