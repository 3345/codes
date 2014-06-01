package ch4;

import dataStructure.MyTree;
import dataStructure.MyTreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class p4_1 {
    public static boolean isBalanced(MyTree tree) {
        if (tree.root.isLeaf())
            return true;

        return getMaxDepth(tree.root) - getMinDepth(tree.root) < 2;
    }

    public static int getMaxDepth(MyTreeNode treeNode) {
        if (treeNode.isLeaf())
            return 0;
        int max = Integer.MIN_VALUE;
        for (Object child : treeNode.children) {
            MyTreeNode child1 = (MyTreeNode)child;
            max = getMaxDepth(child1) > max ? getMaxDepth(child1) : max;

        }
        return max + 1;
    }

    public static int getMinDepth(MyTreeNode treeNode) {
        if (treeNode.isLeaf())
            return 0;
        int min = Integer.MAX_VALUE;
        for (Object child : treeNode.children) {
            MyTreeNode child1 = (MyTreeNode)child;
            min = getMinDepth(child1) < min ? getMaxDepth(child1) : min;

        }
        return min + 1;
    }

    @Test
    public void t1() throws Exception {
        //unbalanced
        MyTreeNode<Integer> node0 = new MyTreeNode<Integer>(0);

        MyTreeNode<Integer> node0_1 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node0_2 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node0_3 = new MyTreeNode<Integer>(0);
        node0.addChildNode(node0_1).addChildNode(node0_2).addChildNode(node0_3);

        MyTreeNode<Integer> node01_1 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node01_2 = new MyTreeNode<Integer>(0);
        node0_1.addChildNode(node01_1).addChildNode(node01_2);

        MyTreeNode<Integer> node03_1 = new MyTreeNode<Integer>(0);
        node0_3.addChildNode(node03_1);

        MyTreeNode<Integer> node012_1 = new MyTreeNode<Integer>(0);
        node01_2.addChildNode(node012_1);

        MyTree<Integer> tree = new MyTree<Integer>(node0);

        assertFalse(isBalanced(tree));
    }

    @Test
    public void t2() throws Exception {
        MyTreeNode<Integer> node0 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node1 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node2 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node3 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node4 = new MyTreeNode<Integer>(0);
        node0.addChildNode(node1).addChildNode(node2);
        node1.addChildNode(node3).addChildNode(node4);

        MyTree tree = new MyTree(node0);
        assertTrue(isBalanced(tree));
    }




}
