import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  Map<Integer, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;
    Node new_head = new Node(node.val);
    visited.put(node.val, new_head);
    addNeighbors(new_head, node.neighbors);
    return new_head;
  }

  public void addNeighbors(Node node, List<Node> neighbors) {
    // DFS
    for (Node n : neighbors) {
      Node new_node;
      if (visited.containsKey(n.val)) {
        new_node = visited.get(n.val);
        node.neighbors.add(new_node);
      } else {
        new_node = new Node(n.val);
        visited.put(new_node.val, new_node);
        node.neighbors.add(new_node);
        addNeighbors(new_node, n.neighbors);
      }
    }
  }
}