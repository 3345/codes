package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by fyl on 12/27/17.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                subList.add(node.val);
                if (node.left != null) {
                    children.add(node.left);
                }

                if(node.right != null) {
                    children.add(node.right);
                }
            }

            list.add(0, subList);
            children.forEach(n -> q.add(n));
        }

        return list;
    }

}
