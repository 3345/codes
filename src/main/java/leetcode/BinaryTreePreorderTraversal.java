package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by yulai on 9/20/15.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Set<TreeNode> visited = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);
        result.add(root.val);
        visited.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !visited.contains(node.left)) {
                visited.add(node.left);
                stack.push(node.left);
                result.add(node.left.val);

            } else {
                stack.pop();

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.left);
                    stack.push(node.right);
                    result.add(node.right.val);
                }
            }

        }

        return result;
    }
}
