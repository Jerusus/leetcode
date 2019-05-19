import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode n : list) {
                vals.add(n.val);
                if (n.left != null) temp.add(n.left);
                if (n.right != null) temp.add(n.right);
            }
            Collections.sort(vals);
            res.add(vals.get(vals.size()-1));
            list = temp;
        }
        return res;
    }
}