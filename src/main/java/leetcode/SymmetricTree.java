package leetcode;

import java.util.LinkedList;

/**
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 But the following is not:
   1
  / \
 2   2
  \   \
  3    3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        if (root.right == null && root.left == null)
            return true;

        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
            q1.add(root.left);
            q2.add(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.pop();
            TreeNode node2 = q2.pop();

            if (node1 == null && node2 != null)
                return false;

            if (node2 == null && node1 != null)
                return false;

            if (node1 != null && node2 != null) {
                if (node1.val != node2.val)
                    return false;

                q1.add(node1.left);
                q1.add(node1.right);

                q2.add(node2.right);
                q2.add(node2.left);
            }
        }

        if (q1.isEmpty() && q2.isEmpty())
            return true;
        else
            return false;
    }
}
