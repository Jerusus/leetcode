import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        getLeaves(root1,s1);
        List<Integer> s2 = new ArrayList<>();
        getLeaves(root2,s2);
        
        if (s1.size() != s2.size()) {
            return false;
        } else {
            for (int i = 0; i < s1.size(); i++) {
                if (s1.get(i) != s2.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void getLeaves(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            getLeaves(root.left, list);
        }
        // in-order or post-order doesn't matter
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.right != null) {
            getLeaves(root.right, list);
        }
    }
}
  
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}