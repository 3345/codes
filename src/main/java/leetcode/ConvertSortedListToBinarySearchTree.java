package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulai on 9/30/15.
 */
public class ConvertSortedListToBinarySearchTree {
    List<Integer> list = new ArrayList<>();


    public TreeNode sortedListToBST(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode cur = head;

        do {
            list.add(cur.val);
            cur = cur.next;
        } while (cur != null);

        return helper(0, list.size() - 1);
    }

    private TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = helper(start, mid - 1);
        root.right = helper(mid + 1, end);

        return root;
    }
}
