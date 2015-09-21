package leetcode;

import dataStructure.MyTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Iterative
 */
public class IterativeTraversal {
    public void postOrderTraverse(MyTreeNode<Integer> root) {
        if (root == null)
            System.out.println("nothing");
        ArrayList<MyTreeNode> result = new ArrayList();
        Stack<MyTreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            MyTreeNode cur = stack.peek();
            if (cur.hasLeft() && !result.contains(cur.getLeft())) {
                stack.push(cur.getLeft());
            } else if (cur.hasRight() && !result.contains(cur.getRight())) {
                stack.push(cur.getRight());
            } else {
                result.add(cur);
                stack.pop();
            }
        }
        for (MyTreeNode node : result) {
            System.out.print(node.data + " ");
        }
    }

    public void preOrderTraverse(MyTreeNode<Integer> root) {
        if (root == null)
            System.out.println("nothing");

        ArrayList<MyTreeNode> result = new ArrayList();
        Stack<MyTreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            MyTreeNode cur = stack.peek();

            if (!result.contains(cur))
                result.add(cur);
            if (cur.hasLeft() && !result.contains(cur.getLeft())) {
                stack.push(cur.getLeft());
            } else if (cur.hasRight() && !result.contains(cur.getRight())) {
                stack.push(cur.getRight());
            } else {
                stack.pop();
            }
        }
        for (MyTreeNode node : result) {
            System.out.print(node.data + " ");
        }

    }

    @Test
    public void postOrder() {
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n5 = new MyTreeNode(5);

        n1.addChildNode(n2).addChildNode(n3);
        n2.addChildNode(n5);

        postOrderTraverse(n1);
    }

    @Test
    public void preOrder() {
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n4 = new MyTreeNode(4);
        MyTreeNode n5 = new MyTreeNode(5);

        n1.addChildNode(n2).addChildNode(n3);
        n2.addChildNode(n5).addChildNode(n4);

        preOrderTraverse(n1);
    }
}
