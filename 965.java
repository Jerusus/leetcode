class Solution {
  public boolean isUnivalTree(TreeNode root) {
    int val = root.val;
    return isUnivalTree(root, val);
  }

  public boolean isUnivalTree(TreeNode root, int val) {
    if (root == null) {
      return true;
    } else if (root.val != val) {
      return false;
    } else {
      return isUnivalTree(root.left,val) && isUnivalTree(root.right,val);
    }
  }
}

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}