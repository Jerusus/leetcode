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

class BSTIterator {
  List<TreeNode> inOrder;
  int i;

  public BSTIterator(TreeNode root) {
    inOrder = new ArrayList<>();
    recurse(root);
    i = -1;
  }

  public int next() {
    i++;
    return inOrder.get(i).val;
  }

  public boolean hasNext() {
    return i < inOrder.size() - 1;
  }

  private void recurse(TreeNode cur) {
    if (cur == null) {
      return;
    }
    recurse(cur.left);
    inOrder.add(cur);
    recurse(cur.right);
  }
}