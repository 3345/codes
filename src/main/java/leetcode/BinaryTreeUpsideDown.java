package leetcode;

/*
   1
   / \
  2   3
 / \
4   5
 */

/*
  4
  / \
 5   2
    / \
   3   1
 */

public class BinaryTreeUpsideDown {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }


    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        TreeNode h1 = root;
        TreeNode h2 = root.left;
        TreeNode h1r = h1.right;
        h1.left = null;
        h1.right = null;


        while (h2 != null) {

            TreeNode nextH2 = h2.left;
            TreeNode h2r = h2.right;
            h2.right = h1;
            h2.left = h1r;

            h1r = h2r;
            h1 = h2;
            h2 = nextH2;
        }

        return h1;
    }

}
