package leetcode;


import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by fyl on 11/25/16.
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
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


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.removeFirst();

            if (n instanceof  DumNode) {
                sb.append("x ");
                continue;
            } else {
                sb.append(n.val + " ");
            }

            if (n.left == null) {
                q.add(new DumNode(0));
            } else {
                q.add(n.left);
            }

            if (n.right == null) {
                q.add(new DumNode(0));
            } else {
                q.add(n.right);
            }
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }

        String[] arr = data.split(" ");
        int len = arr.length;

        LinkedList<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        int i = 0;

        while (!q.isEmpty()) {
            TreeNode n = q.removeFirst();

            if (i + 1 < len && !"x".equals(arr[i+1])) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i + 1]));
                n.left = left;
                q.add(left);
            }

            if (i + 2 < len && !"x".equals(arr[i + 2])) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i + 2]));
                n.right = right;
                q.add(right);
            }

            i += 2;
        }

        return root;

    }

    @Test
    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);

        n3.left = n2;
        n3.right = n4;
        n2.left = n1;

        SerializeandDeserializeBinaryTree o = new SerializeandDeserializeBinaryTree();

        String s = o.serialize(n3);

        TreeNode n = o.deserialize(s);

        System.out.print(n);
    }
}
