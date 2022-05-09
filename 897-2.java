import java.util.ArrayList;
import java.util.List;

public class TreeNode {
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
  public TreeNode increasingBST(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<>();
    traverse(root, nodes);
    TreeNode result_root = nodes.get(0);
    TreeNode cur = result_root;
    for (int i = 1; i < nodes.size(); i++) {
      cur.right = nodes.get(i);
      cur = cur.right;
    }
    return result_root;
  }

  void traverse(TreeNode root, List<TreeNode> nodes) {
    if (root == null) {
      return;
    }
    traverse(root.left, nodes);
    nodes.add(new TreeNode(root.val));
    traverse(root.right, nodes);
  }
}