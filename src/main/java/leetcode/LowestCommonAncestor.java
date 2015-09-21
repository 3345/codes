package leetcode;

import org.junit.Test;

public class LowestCommonAncestor {
    TreeNode lca(TreeNode p, TreeNode q, TreeNode root) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode leftLca = lca(p, q, root.left);
        TreeNode rightLca = lca(p, q, root.right);

        if (leftLca != null && rightLca != null)
            return root;

        return leftLca == null ? rightLca : leftLca;
    }

    /**
     *_______3______
     /              \
     ___5__          ___1__
     /      \        /      \
     6      _2       0       8
     /  \
     7   4
     */
    @Test
    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);

        n3.left = n5; n3.right = n1;
        n5.left = n6; n5.right = n2;
        n1.left = n0; n1.right = n8;
        n6.left = n7; n6.right = n4;

        System.out.println(lca(n5, n2, n3).val);
    }
}
