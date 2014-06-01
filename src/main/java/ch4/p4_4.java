package ch4;

import dataStructure.MyQueue;
import dataStructure.MyTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class p4_4 {
    public static void findLevelLinkedListHelper(ArrayList<LinkedList<MyTreeNode>> listOflists, MyQueue<MyTreeNode> queue) {

        if (!queue.isEmpty()) {
            MyTreeNode node = (MyTreeNode) queue.dequeue().data;
            if (node.data != null) {
                listOflists.get(listOflists.size() - 1).add(node);

                if (!node.isLeaf()) {
                    for (Object obj: node.children) {
                        MyTreeNode childNode = (MyTreeNode)obj;
                        queue.enqueue(childNode);
                    }
                }

            } else {
                if (!queue.isEmpty()) {
                    queue.enqueue(node);
                    LinkedList<MyTreeNode> list = new LinkedList<MyTreeNode>();
                    listOflists.add(list);
                }
            }

            findLevelLinkedListHelper(listOflists, queue);
        }
    }

    public static ArrayList findLevelLinkedList(MyTreeNode root) {
        ArrayList<LinkedList<MyTreeNode>> listOflists = new ArrayList<LinkedList<MyTreeNode>>();
        MyQueue<MyTreeNode> queue = new MyQueue<MyTreeNode>();
        queue.enqueue(new MyTreeNode(null));
        queue.enqueue(root);
        findLevelLinkedListHelper(listOflists, queue);
        return listOflists;
    }

    @Test
    public void t1() throws Exception {
        MyTreeNode n0 = new MyTreeNode(0);
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n4 = new MyTreeNode(4);
        MyTreeNode n5 = new MyTreeNode(5);
        MyTreeNode n6 = new MyTreeNode(6);

        n0.addChildNode(n1).addChildNode(n2);
        n1.addChildNode(n3).addChildNode(n4);
        n2.addChildNode(n5).addChildNode(n6);

        ArrayList ans = findLevelLinkedList(n0);
        System.out.println(ans);


    }

    @Test
    public void t2() throws Exception {
        ArrayList l1 = new ArrayList();
        l1.add("a");
        l1.add(4, "b");

    }
}
