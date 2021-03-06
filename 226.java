public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.right = invertTree(left);
    root.left = invertTree(right);
    return root;
  }
}