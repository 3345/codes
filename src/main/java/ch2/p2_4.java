package ch2;

import dataStructure.MyLinkedList;
import dataStructure.MyNode;
import org.junit.Test;

import java.util.Arrays;

public class p2_4 {
    public MyLinkedList addNumbers(MyLinkedList l1, MyLinkedList l2) {
        MyLinkedList out = new MyLinkedList();
        int carry;
        MyNode<Integer> cur1 = l1.head;
        MyNode<Integer> cur2 = l2.head;
        if (cur1 == null) {
            return l2;
        }
        if (cur2 == null) {
            return l1;
        }

        int result = cur1.data + cur2.data;
        if (result > 9) {
            result -= 10;
            carry = 1;
        }
        else {
            carry = 0;
        }
        MyNode<Integer> cur = out.head;
        out.head.data = result;
        while (cur1.hasNext()) {
            cur1 = cur1.next;
            if (cur2.hasNext()) {
                cur2 = cur2.next;
                result = cur1.data + cur2.data + carry;
                if (result > 9) {
                    result -= 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                cur.next = new MyNode<Integer>(result);
                cur = cur.next;
            }
            else {
                result = cur1.data + carry;
                if (result > 9) {
                    result -= 10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                cur.next = new MyNode<Integer>(result);
                cur = cur.next;
            }
        }
        while (cur2.hasNext()) {
            cur2 = cur2.next;
            result = cur2.data + carry;
            if (result > 9) {
                result -= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            cur.next = new MyNode<Integer>(result);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new MyNode<Integer>(carry);
        }
        return out;
    }

    @Test
    public void t1() {
        MyLinkedList l1 = new MyLinkedList(Arrays.asList(8,4,1));
        MyLinkedList l2 = new MyLinkedList(Arrays.asList(2,3,4,5,9));
        MyLinkedList l3 = this.addNumbers(l1, l2);
        System.out.println(l3.toArrayList());
    }
}
