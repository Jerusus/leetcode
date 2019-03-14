class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        preorder(root, list);        
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
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
