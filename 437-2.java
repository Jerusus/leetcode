import java.util.HashMap;
import java.util.Map;

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
  // Done with prefix sums.
  int targetSum;
  Map<Integer, Integer> map;
  int res;

  public int pathSum(TreeNode root, int targetSum) {
    this.targetSum = targetSum;
    res = 0;
    map = new HashMap<>();
    map.put(0, 1);
    path(root, 0);
    return res;
  }

  void path(TreeNode root, int cur) {
    if (root == null) {
      return;
    }
    cur += root.val;
    res += map.getOrDefault(cur - targetSum, 0);
    map.put(cur, map.getOrDefault(cur, 0) + 1);
    path(root.left, cur);
    path(root.right, cur);
    map.put(cur, map.get(cur) - 1);
  }
}