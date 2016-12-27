package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        Queue<Integer> levelQ = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        levelQ.add(0);
        int targetLevel = 0;

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            Integer level = levelQ.poll();

            if (n.left != null) {
                q.add(n.left);
                levelQ.add(level + 1);
            }

            if (n.right != null) {
                q.add(n.right);
                levelQ.add(level + 1);
            }

            if (level == targetLevel) {
                if (level % 2 == 0) {
                    list.add(n.val);
                } else {
                    list.add(0, n.val);
                }
            } else {
                targetLevel = level;
                ans.add(list);
                list = new ArrayList<>();
                if (level % 2 == 0) {
                    list.add(n.val);
                } else {
                    list.add(0, n.val);
                }
            }

            if (q.isEmpty()) {
                ans.add(list);
            }
        }

        return ans;
    }
}
