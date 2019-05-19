public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        calc(root);
        return max - 1;
    }

    private int calc(TreeNode root) {
        if (root == null) {
            max = Math.max(max, 0);
            return 0;
        } else {
            int l = calc(root.left);
            int r = calc(root.right);
            max = Math.max(l+r+1, max);
            return Math.max(l,r) + 1;
        }
    }
}