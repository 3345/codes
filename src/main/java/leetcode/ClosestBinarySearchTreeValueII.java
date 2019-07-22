package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 7/19/19.
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> sm = this.inorder(root, target);
        List<Integer> lg = this.reverseorder(root, target);
        List<Integer> res = new ArrayList<>();

        int is = sm.size() - 1;
        int il = lg.size() - 1;
        for (int i = 0; i < k; i++) {
            if (is < 0 && il >= 0) {
                res.add(lg.get(il));
                il--;
                continue;
            }
            if (il < 0 && is >= 0) {
                res.add(sm.get(is));
                is--;
                continue;
            }
            if (is < 0 && il < 0) {
                break;
            }
            if (Math.abs(sm.get(is) - target) < Math.abs(lg.get(il) - target)) {
                res.add(sm.get(is));
                is--;
            } else {
                res.add(lg.get(il));
                il--;
            }
        }
        return res;
    }

    public List<Integer> inorder(TreeNode n, double target) {
        if (n == null) {
            return new ArrayList<>();
        }

        List<Integer> left = inorder(n.left, target);
        if (n.val > target) {
            return left;
        }
        left.add(n.val);
        List<Integer> right = inorder(n.right, target);
        left.addAll(right);
        return left;
    }

    public List<Integer> reverseorder(TreeNode n, double target) {
        if (n == null) {
            return new ArrayList<>();
        }

        List<Integer> right = reverseorder(n.right, target);
        if (n.val <= target) {
            return right;
        }
        right.add(n.val);
        List<Integer> left = reverseorder(n.left, target);
        right.addAll(left);
        return right;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        ClosestBinarySearchTreeValueII sol = new ClosestBinarySearchTreeValueII();
        sol.closestKValues(n1, 3.71286, 2);
    }
}
