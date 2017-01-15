package leetcode;

/**
 * Created by fyl on 1/14/17.
 */
public class PopulatingNextRightPointersinEachNodeII {
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
        TreeLinkNode head;
        TreeLinkNode cur;

        if (root.left != null) {
            head = root.left;
        } else {
            head = root.right;
        }

        cur = head;

        while (cur != null) {
            if (up.right != null && up.right != cur) {
                cur.next = up.right;
                cur = cur.next;
            }

            if (up.next != null) {
                up = up.next;
                if (up.left != null) {
                    cur.next = up.left;
                    cur = cur.next;
                }
            } else if (head != null) {
                up = head;

                while (up.left == null && up.right == null) {
                    if (up.next == null) {
                        return;
                    } else {
                        up = up.next;
                    }
                }

                if (up.left != null) {
                    head = up.left;
                } else {
                    head = up.right;
                }

                cur = head;
            } else {
                break;
            }
        }

    }
}
