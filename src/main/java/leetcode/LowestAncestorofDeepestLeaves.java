package leetcode;

import org.junit.Test;

public class LowestAncestorofDeepestLeaves {
    int dl = 0;
    TreeNode dn = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        re(0,root);
        return dn;
    }

    public int re(int d, TreeNode node) {
        if (node.left == null && node.right == null) {
            if (dl < d+1) {
                dl = d+1;
                dn = node;
            }
            return d+1;
        }
        int ll = -1; int rl = -1;
        if (node.left != null) {
            ll = re(d+1, node.left);
        }
        if (node.right != null) {
            rl = re(d+1, node.right);
        }
        if (ll == rl) {
            if (ll > dl) {
                dn = node;
            }
            return ll;
        }
        return Math.max(ll,rl);
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2; n1.right = n3;
        lcaDeepestLeaves(n1);
    }

}
