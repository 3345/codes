package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by fyl on 12/5/16.
 */
public class SerializeAndDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);

            StringBuilder sb = new StringBuilder();

            while (!q.isEmpty()) {
                TreeNode n = q.removeFirst();
                sb.append(n.val + ",");
                if (n.left != null) {
                    q.add(n.left);
                }

                if (n.right != null) {
                    q.add(n.right);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }

            String[] arr = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

            for (int i = 1; i < arr.length; i++) {
                put(root, new TreeNode(Integer.parseInt(arr[i])));
            }

            return root;
        }

        public void put(TreeNode root, TreeNode n) {
            if (n.val > root.val) {
                if (root.right == null) {
                    root.right = n;
                    return;
                } else {
                    put(root.right, n);
                }
            } else {
                if (root.left == null) {
                    root.left = n;
                    return;
                } else {
                    put(root.left, n);
                }
            }
        }

        @Test
        public void t() {
            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(1);
            root.right = new TreeNode(3);

            String s = serialize(root);
            System.out.println(s);

            TreeNode r = deserialize(s);
            System.out.println(new Gson().toJson(r));
        }
    }

    @Test
    public void t() {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String s = codec.serialize(root);
        System.out.println(s);

        TreeNode r = codec.deserialize(s);
        System.out.println(new Gson().toJson(r));
    }


}
