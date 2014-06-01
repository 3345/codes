package ch4;

import dataStructure.MyTreeNode;
import org.junit.Test;

public class p4_6 {
    public MyTreeNode commonAncestor(MyTreeNode current, MyTreeNode p, MyTreeNode q) {
        Boolean leftHasP = cover(current.getLeft(), p);
        Boolean leftHasQ = cover(current.getLeft(), q);
        Boolean rightHasP = cover(current.getRight(), p);
        Boolean rightHasQ = cover(current.getRight(), q);

        if (leftHasP && leftHasQ)
            return commonAncestor(current.getLeft(), p ,q);
        if (rightHasP && rightHasQ)
            return commonAncestor(current.getRight(), p, q);
        if ((leftHasP && rightHasQ) || (leftHasQ && rightHasP))
            return current;

        return null;

    }

    private boolean cover(MyTreeNode root, MyTreeNode node) {
        if (root == null)
            return false;
        if (root.equals(node))
            return true;

        return cover(root.getLeft(), node) || cover(root.getRight(), node);

    }

    @Test
    public void t1() {
        MyTreeNode<Integer> node0 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node1 = new MyTreeNode<Integer>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<Integer>(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<Integer>(3);
        MyTreeNode<Integer> node4 = new MyTreeNode<Integer>(4);
        MyTreeNode<Integer> node5 = new MyTreeNode<Integer>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<Integer>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<Integer>(7);
        MyTreeNode<Integer> node8 = new MyTreeNode<Integer>(8);
        MyTreeNode<Integer> node9 = new MyTreeNode<Integer>(9);
        MyTreeNode<Integer> nodeX = new MyTreeNode<Integer>(-1);

        /*
              0
           1    2
         3  4  5 6
        7 8    9
         */

        node0.addChildNodes(node1, node2);
        node1.addChildNodes(node3, node4);
        node2.addChildNodes(node5, node6);
        node3.addChildNodes(node7, node8);
        node5.addChildNodes(node9);

        System.out.println(commonAncestor(node0, node4, node7).data);
        System.out.println(commonAncestor(node0, node5, node7).data);
        System.out.println(commonAncestor(node0, node3, node4).data);
        System.out.println(commonAncestor(node0, node1, nodeX));

    }

}
