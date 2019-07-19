package lintcode;

import org.junit.Test;

/**
 * Created by fyl on 7/18/19.
 */
public class MinimumSubTree {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private TreeNode minNode;
    private int min = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        sum(root);
        return minNode;
    }

    private int sum(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (this.minNode == null) {
            this.minNode = n;
        }
        int sum = this.sum(n.left) + this.sum(n.right) + n.val;
        if (this.minNode == null) {

        }
        if (sum < this.min) {
            this.minNode = n;
            this.min = sum;
        }
        return sum;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.right = n2;
        MinimumSubTree sol = new MinimumSubTree();
        sol.findSubtree(n1);
    }
}
