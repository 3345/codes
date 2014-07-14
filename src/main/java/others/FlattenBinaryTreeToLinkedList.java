package others;

import org.junit.Test;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        TreeNode end;
        if (root.left == null) {
            if (root.right != null)
                end = flat(root.right);
            else
                end = root;
        }  else {
            if (root.right != null) {
                flat(root.left).right = root.right;
                end = flat(root.right);
                root.right = root.left;
            } else {
                end = flat(root.left);
                root.right = root.left;
            }
            root.left = null;
        }
        return end;
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
