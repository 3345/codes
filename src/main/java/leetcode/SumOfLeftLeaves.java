package leetcode;

public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return solve(root.left, true) + solve(root.right, false);

    }

    public int solve(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }

        return solve(node.left, true) + solve(node.right, false);
    }
}
