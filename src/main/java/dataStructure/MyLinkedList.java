package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    public MyNode head;

    public MyLinkedList() {
        head = new MyNode();
    }

    public MyLinkedList(MyNode h) {
        head = h;
    }

    public MyLinkedList(List list) {
        if (list.size() < 1) {
            head = null;
            return;
        }
        MyNode h = new MyNode(list.get(0));
        head = h;
        MyNode current = h;
        for (int i = 1; i < list.size(); i++) {
            MyNode next = new MyNode(list.get(i));
            current.next = next;
            current = next;
        }
    }

    public void append(MyNode n) {
        MyNode current = head;
        while (current.hasNext()) {
            current = current.next;
        }
        current.next = n;
    }

    public boolean removeNext(MyNode n) {
        if (!n.hasNext())
            return false;
        else {
            n.next = n.next.next;
            return true;
        }
    }

    public ArrayList toArrayList() {
        MyNode current = head;
        ArrayList arrayList = new ArrayList();
        arrayList.add(current.data);
        while (current.hasNext()) {
            arrayList.add(current.next.data);
            current = current.next;
        }
        return arrayList;
    }

    public void print(int limit) {
        MyNode cur = head;
        System.out.print(cur.data + " ");
        while (cur.hasNext() && limit > 1) {
            System.out.print(cur.next.data + " ");
            cur = cur.next;
            limit --;
        }
    }

    public void print() {
        print(Integer.MAX_VALUE);
    }

    public MyNode get(int index) {
        MyNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.hasNext()) {
                cur = cur.next;
            }
            else {
                return null;
            }
        }
        return cur;
    }
}
