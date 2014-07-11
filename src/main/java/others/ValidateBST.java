package others;

import dataStructure.MyTreeNode;
import org.junit.Test;

public class ValidateBST {
    public boolean validate(MyTreeNode<Integer> root, int min, int max) {
        boolean isLeftBST = true;
        boolean isRightBST = true;
        if (root.data >= max || root.data <= min)
            return false;
        if (root.hasLeft()) {
            isLeftBST = validate(root.getLeft(), min, root.data);
        }
        if (root.hasRight()) {
            isRightBST = validate(root.getRight(), root.data, max);
        }
        return isLeftBST && isRightBST;
    }

    @Test
    public void t() {
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(1);
        n1.addChildNode(n2);

        System.out.println(validate(n1, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
