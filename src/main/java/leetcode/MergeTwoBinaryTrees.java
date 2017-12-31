package leetcode;

/**
 * Created by fyl on 12/29/17.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;

        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null) {
            root = t2;
        } else if (t2 == null) {
            root = t1;
        }

        return root;
    }

}
