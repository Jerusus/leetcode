import java.util.Arrays;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int val = preorder[0];
        TreeNode n = new TreeNode(val);
        int index = preorder.length;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > val) {
                index = i;
                break;
            }
        }
        n.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, index));
        n.right = bstFromPreorder(Arrays.copyOfRange(preorder, index, preorder.length));
        return n;
    }
}