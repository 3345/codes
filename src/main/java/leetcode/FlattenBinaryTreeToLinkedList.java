package leetcode;

import org.junit.Test;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // write your code here
        recur(root);
    }

    public TreeNode recur(TreeNode n) {
        if (n == null) {
            return n;
        }

        TreeNode l = recur(n.left);
        TreeNode r = recur(n.right);
        n.right = appendTail(l, r);
        n.left = null;
        return n;
    }
    //append n2 to n1
    public TreeNode appendTail(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return n2;
        }
        TreeNode tail = n1;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = n2;
        return n1;
    }

    /**
     *
     *  1
     * / \
      2   5
     / \   \
    3   4   6
     */
    @Test
    public void t() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;

        flatten(n1);
        System.out.println();
    }
}
