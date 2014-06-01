package ch2;

import dataStructure.MyLinkedList;
import dataStructure.MyNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class p2_3 {
    public boolean removeLimitedAccess(MyNode n) {
        if (!n.hasNext()) {
            return false;
        }

        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    @Test
    public void t1() {
        List list = Arrays.asList(0,1,2,3,4,5);
        MyLinkedList linkedList = new MyLinkedList(list);
        MyNode node = linkedList.get(3);
        System.out.println(removeLimitedAccess(node));
        System.out.println(linkedList.toArrayList());
    }
}
