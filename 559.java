class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    public int maxDepth(Node root, int current) {
        if (root.children == null || root.children.size() == 0) {
            return current;
        }
        
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(maxDepth(child, current + 1), max);
        }
        return max;
    }
}
  
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
