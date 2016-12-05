package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class DumNode extends TreeNode {

        DumNode(int x) {
            super(x);
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        q.add(root);
        q.add(new DumNode(0));

        while (!q.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            TreeNode n = q.removeFirst();

            while (!(n instanceof DumNode)) {
                level.add(n);
                n = q.removeFirst();
            }

            ans.add(level.get(level.size() - 1).val);

            for (TreeNode node : level) {
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            if (!q.isEmpty()) {
                q.add(new DumNode(0));
            }

        }

        return ans;

    }


}
