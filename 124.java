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
  int max_seen = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    // Set cur value equal to max(cur.val, cur.val + max(cur.left.val,
    // cur.right.val)).
    // Set max seen value equal to cur.val + cur.left.val + cur.right.val.

    path(root);

    return max_seen;
  }

  int path(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = path(root.left);
    int right = path(root.right);
    int max_pick_one = root.val + Math.max(0, Math.max(left, right));
    max_seen = Math.max(max_seen, Math.max(max_pick_one, root.val + left + right));
    return max_pick_one;
  }
}