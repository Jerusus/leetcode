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
  List<TreeNode> inOrder;

  public int kthSmallest(TreeNode root, int k) {
    inOrder = new ArrayList<>();
    doInOrder(root);
    return inOrder.get(k - 1).val;
  }

  void doInOrder(TreeNode root) {
    if (root == null)
      return;
    doInOrder(root.left);
    inOrder.add(root);
    doInOrder(root.right);
  }
}