package leetcode;

import java.util.ArrayList;
import java.util.List;


public class FindLeavesofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        getLevel(root, ans);

        return ans;
    }

    public int getLevel (TreeNode n, List<List<Integer>> ans) {
        if (n.left == null && n.right == null) {
            if (ans.size() < 1) {
                ans.add(new ArrayList<Integer>());
            }

            ans.get(0).add(n.val);


            return 0;
        }

        int i;

        if (n.left != null && n.right != null) {
            i = 1 + Math.max(getLevel(n.left, ans), getLevel(n.right, ans));
        } else if (n.left != null) {
            i = 1 + getLevel(n.left, ans);

        } else {
            i = 1 + getLevel(n.right, ans);
        }

        if (ans.size() < i + 1) {
            ans.add(new ArrayList<Integer>());
        }

        ans.get(i).add(n.val);

        return i;
    }
}
