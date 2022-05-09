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
  int count;
  int target;

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    count = 0;
    target = targetSum;
    path(root);
    return count;
  }

  void path(TreeNode root) {
    if (root == null)
      return;
    take(root, 0);
    path(root.left);
    path(root.right);
  }

  void take(TreeNode root, int val) {
    if (root == null)
      return;
    val += root.val;
    if (val == target)
      count++;
    take(root.left, val);
    take(root.right, val);
  }
}

/*
 * 
 * [5,4,8,11,null,13,4,7,2,null,null,5,1]
 * 22
 * 
 * expected 3
 * 
 * [1,null,2,null,3,null,4,null,5]
 * 3
 * 
 * expected 2
 */