package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fyl on 12/5/16.
 */
public class SerializeAndDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            traverse(root, arr);
            StringBuilder sb = new StringBuilder();
            for (Integer i : arr) {
                sb.append(this.itoa(i));
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int len = data.length() / 4;
            int[] a = new int[len];
            for (int i = 0; i < data.length() / 4; i++) {
                int num = this.atoi(data.substring(i*4, i*4 + 4));
                a[i] = num;
            }
            return buildTree(a, 0, len);
        }

        //inorder
        private void traverse(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            traverse(root.left, list);
            traverse(root.right, list);
        }

        private TreeNode buildTree(int[] a, int s, int e) {
            if (s >= e) {
                return null;
            }
            TreeNode root = new TreeNode(a[s]);
            if (e - s == 1) {
                return root;
            }
            int mid = e;
            for (int i = s + 1; i < e; i++) {
                if (a[i] > a[s]) {
                    mid = i;
                    break;
                }
            }

            root.left = buildTree(a, s + 1, mid);
            root.right = buildTree(a, mid, e);
            return root;
        }

        private String itoa(int num) {
            String s = "";
            int mask = 0xFF;
            for (int i = 0; i < 4; i++) {
                char seg = (char) (num & mask);
                s = seg + s;
                num = num >>> 8;
            }
            return s;
        }

        private int atoi(String s) {
            int ret = 0;
            for (int i = 0; i < 4; i++) {
                char c = s.charAt(i);
                int num = c << (3 - i) * 8;
                ret = ret | num;
            }
            return ret;
        }

    }

    @Test
    public void test() {
        Codec codec = new Codec();
        TreeNode n1 = new TreeNode(5);
        n1.left = new TreeNode(1);
        String s = codec.serialize(n1);
        TreeNode n2 = codec.deserialize(s);
        System.out.println(n2);
    }


}
