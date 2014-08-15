package others;

/**
 * Created by yfu on 8/3/14.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        TreeNode right = root.right;
        TreeNode left = root.left;

        if (left == null && right == null)
            return true;

        return isBalanced(left) && isBalanced(right) && (Math.abs(height(left) - height(right)) <= 1);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
