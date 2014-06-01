package ch4;

import dataStructure.MyTreeNode;
import org.junit.Test;

public class p4_3 {
    public static void minBst(int [] array, MyTreeNode root) {
        if (array.length == 0)
            return;
        root.data = array[array.length/2];
        int leftSize = (int)Math.floor(array.length/2);
        int rightSize = array.length - leftSize - 1;
        if (leftSize > 0) {
            MyTreeNode leftChild = new MyTreeNode(null);
            root.addChildNode(leftChild);
            int [] leftArray = new int[leftSize];
            System.arraycopy(array, 0, leftArray, 0, leftSize);
            minBst(leftArray, leftChild);
        }
        if (rightSize > 0) {
            MyTreeNode rightChild = new MyTreeNode(null);
            root.addChildNode(rightChild);
            int [] rightArray = new int[rightSize];
            System.arraycopy(array, leftSize + 1, rightArray, 0, rightSize);
            minBst(rightArray, rightChild);
        }
    }

    @Test
    public void t1() throws Exception {
        int [] array = {0, 1, 2, 3, 4, 5, 6};
        MyTreeNode root = new MyTreeNode(null);
        minBst(array, root);
        System.out.print(root);
    }
}
