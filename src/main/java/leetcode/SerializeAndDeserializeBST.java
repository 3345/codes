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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    public void traverse(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(itoa(node.val));
        traverse(node.left, sb);
        traverse(node.right, sb);
    }

    private char[] itoa(int n) {
        char[] arr = new char[4];
        arr[0] = (char)((n >>> 24) & 0xFF);
        arr[1] = (char)((n >>> 16) & 0xFF);
        arr[2] = (char)((n >>> 8) & 0xFF);
        arr[3] = (char)((n) & 0xFF);
        return arr;
    }

    private int atoi(char[] arr) {
        return (int)arr[0] << 24
                | (int)arr[1] << 16
                | (int)arr[2] << 8
                | (int)arr[3];
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] arr = new int[data.length()/4];
        char[] ca = data.toCharArray();
        for (int i = 0; i < data.length()/4; i++) {
            arr[i] = atoi(new char[]{ca[4*i],ca[4*i+1],ca[4*i+2],ca[4*i+3]});
        }
        return makeTree(arr, 0, arr.length-1);
    }

    private TreeNode makeTree(int[] arr, int start, int end) {
        if (start > end) return null;
        TreeNode n = new TreeNode(arr[start]);
        int mid = end+1;
        for (int i = start+1; i <= end; i++) {
            if (arr[i] > arr[start]) {
                mid = i;
                break;
            }
        }
        n.left = makeTree(arr, start+1, mid-1);
        n.right = makeTree(arr, mid, end);
        return n;
    }

    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1; n2.right = n3;
        String s = serialize(n2);
        deserialize(s);
    }


}
