package leetcode;

/**
 * Created by fyl on 1/2/17.
 */
public class InorderSuccessorInBST {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (p == null) {
                return null;
            }

            if (p.right != null) {
                TreeNode n = p.right;

                while (n.left != null) {
                    n = n.left;
                }

                return n;
            }

            TreeNode ans = null;
            TreeNode n = root;

            while (n != null) {
                if (n == p) {
                    return ans;
                }

                if (n.val > p.val) {
                    ans = n;
                    n = n.left;
                } else {
                    n = n.right;
                }


            }

            return null;
        }
}
