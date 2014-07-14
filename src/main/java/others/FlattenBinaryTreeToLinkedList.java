package others;

public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root.left == null) {
            if (root.right != null)
                return flat(root.right);
            else
                return root;
        }  else {
            if (root.right != null) {
                flat(root.left).right = root.right;
                TreeNode end = flat(root.right);
                root.right = root.left;
                return end;
            } else {
                TreeNode end = flat(root.left);
                root.right = root.left;
                return end;
            }
        }

    }
}
