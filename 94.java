import java.util.ArrayList;
import java.util.List;

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
  List<Integer> res;

  public List<Integer> inorderTraversal(TreeNode root) {
    res = new ArrayList<>();
    doInOrder(root);
    return res;
  }

  void doInOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    doInOrder(root.left);
    res.add(root.val);
    doInOrder(root.right);
  }
}