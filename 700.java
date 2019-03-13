class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return root;
    }
    int cur = root.val;
    if (val > cur) {
      return searchBST(root.right, val);
    } else if (val < cur) {
      return searchBST(root.left, val);
    } else {
      return root;
    }
  }
}

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}