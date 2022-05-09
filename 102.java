import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    int level = 0;
    if (root != null) {
      q.add(root);
      level++;
    }
    while (!q.isEmpty()) {
      List<Integer> l = new ArrayList<>();
      int cur_level = level;
      for (int i = 0; i < cur_level; i++) {
        TreeNode cur = q.poll();
        l.add(cur.val);
        if (cur.left != null) {
          q.add(cur.left);
          level++;
        }
        if (cur.right != null) {
          q.add(cur.right);
          level++;
        }
      }
      res.add(l);
      level -= cur_level;
    }
    return res;
  }
}