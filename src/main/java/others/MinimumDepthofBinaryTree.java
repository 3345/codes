package others;

import org.junit.Test;

import java.nio.file.FileSystemNotFoundException;
import java.util.LinkedList;

/**
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();
        queue.add(root);
        depthQueue.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeLast();
            int depth = depthQueue.removeLast();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.addFirst(node.left);
                depthQueue.addFirst(depth + 1);
            }
            if (node.right != null) {
                queue.addFirst(node.right);
                depthQueue.addFirst(depth + 1);
            }
        }
        return -1;
    }

    @Test
    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n5;
        n20.right = n7;
        System.out.println(minDepth(n3));

    }

}
