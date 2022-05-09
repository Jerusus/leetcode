class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
  }

  boolean isValidBST(TreeNode root, long lower, long higher) {
    if (root == null) {
      return true;
    }
    return root.val > lower && root.val < higher && isValidBST(root.left, lower, root.val)
        && isValidBST(root.right, root.val, higher);
  }
}