package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 */
public class BinaryTreeLevelOrderTraversal {
    Queue<TreeNode> queue = new LinkedList<>();
    int count;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        count = 1;

        while (count > 0) {
            result.add(traverseLevel());
        }

        return result;
    }

    public List<Integer> traverseLevel() {
        int nextCount = 0;
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < count; i ++) {
            TreeNode node = queue.poll();

            ret.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextCount ++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextCount ++;
            }
        }

        count = nextCount;
        return ret;
    }
}
