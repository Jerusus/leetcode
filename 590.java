class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        postorder(root, list);        
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        for (Node child : root.children) {
            postorder(child, list);
        }
        list.add(root.val);
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
