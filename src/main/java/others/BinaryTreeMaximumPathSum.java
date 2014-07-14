package others;

import dataStructure.TreeNode;
import org.junit.Test;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxSum(root, max);
        return max[0];
    }

    //max sum including node
    public int maxSum(TreeNode node, int[] max) {
        if (node == null)
            return 0;
        int localMax = node.val;
        int left = maxSum(node.left, max);
        int right = maxSum(node.right, max);
        if (left > 0)
            localMax += left;
        if (right > 0)
            localMax += right;
        if (localMax > max[0])
            max[0] = localMax;
        if (right > 0 || left > 0)
            return Math.max(node.val + left, node.val + right);
        else
            return node.val;
    }

    @Test
    public void t1() {
        TreeNode n1 = new TreeNode(1);
        System.out.println(maxPathSum(n1));
    }
}
