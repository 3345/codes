package leetcode;

public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = head;
        boolean first = true;

        ListNode ret = h;
        ListNode p = null;

        while (isDeep(h, k)) {
            ListNode[] arr = rev(h ,k);
            if (first) {
                ret = arr[0];
                first = false;
            }

            h = arr[1].next;

            if (p != null) {
                p.next = arr[0];
            }

            p = arr[1];
        }


        return ret;
    }

    public ListNode[] rev(ListNode h, int num) {
        if (h == null) {
            return null;
        }


        ListNode oh = h;

        ListNode n = h.next;
        h.next = null;

        for (int i = 0; i < num - 1; i++) {
            ListNode nn = n.next;
            n.next = h;
            h = n;
            n = nn;
        }

        oh.next = n;


        return new ListNode[]{h, oh};
    }

    public boolean isDeep(ListNode h, int num) {
        for (int i = 0; i < num; i ++) {
            if (h == null) {
                return false;
            }

            h = h.next;
        }

        return true;
    }
}
