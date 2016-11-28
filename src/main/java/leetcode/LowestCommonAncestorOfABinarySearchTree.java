package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 11/27/16.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p == q) {
            return p;
        }

        List<TreeNode> pathToP = new ArrayList<>();

        TreeNode cur = root;

        while (cur != null) {
            pathToP.add(cur);
            if (cur == p) {
                break;
            }
            if (cur.val < p.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        cur = root;
        TreeNode ancestor = pathToP.get(0);

        while (cur != null) {
            if (pathToP.contains(cur)) {
                ancestor = cur;
            } else {
                return ancestor;
            }
            if (cur == q) {
                break;
            }

            if (cur.val < q.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return ancestor;


    }

}
