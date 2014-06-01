package ch4;

import dataStructure.MyTreeNode;

public class p4_5 {
    public static MyTreeNode getNext (MyTreeNode node) {
        if (node == null)
            return null;
        if (node.hasRight())
            return getLeftMost(node.getRight());
        if (node.isLeft())
            return node.parent;
        return getNext(node.parent);
    }

    public static MyTreeNode getLeftMost (MyTreeNode node) {
        if (!node.hasLeft())
            return node;
        return getLeftMost(node.getLeft());
    }
}
