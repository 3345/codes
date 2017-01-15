package leetcode;


public class PopulatingNextRightPointersinEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode up = root;
        TreeLinkNode head = root.left;
        TreeLinkNode cur = root.left;

        while (cur != null) {
            cur.next = up.right;
            cur = cur.next;

            if (up.next != null) {
                up = up.next;
                cur.next = up.left;
                cur = cur.next;
            } else if (head != null) {
                up = head;
                head = up.left;
                cur = head;
            } else {
                break;
            }
        }

    }
}
