package ch2;

import dataStructure.MyLinkedList;
import dataStructure.MyNode;
import org.junit.Test;

import java.util.Arrays;

public class p2_5 {
    public MyNode beginningOfLoop(MyLinkedList linkedList) {
        MyNode fastCur = linkedList.head;
        MyNode slowCur = linkedList.head;
        if (slowCur.next == null || fastCur.next.next == null) {
            return null;
        }
        slowCur = slowCur.next;
        fastCur = fastCur.next.next;
        while (!fastCur.equals(slowCur)) {
            if (fastCur.next == null) {
                return null;
            }  else if(fastCur.next.next == null) {
                return null;
            }
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }
        fastCur = linkedList.head;
        while(!fastCur.equals(slowCur)) {
            slowCur = slowCur.next;
            fastCur = fastCur.next;
        }
        return fastCur;
    }

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList(Arrays.asList(1,1,2,2,3,4,5,6,6,3));
        MyNode<Integer> beginLoop = new MyNode<Integer>(0);
        linkedList.append(beginLoop);
        for (int i = 0; i < 5; i ++) {
            linkedList.append(new MyNode<Integer>(-1));
        }
        linkedList.append(beginLoop);
        linkedList.print(20);
        System.out.println("\n" + beginningOfLoop(linkedList).data);
    }
}
