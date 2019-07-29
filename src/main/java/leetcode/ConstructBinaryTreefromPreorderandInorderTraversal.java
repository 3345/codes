package leetcode;

import org.junit.Test;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    int[] preorder = null;
    int[] inorder = null;
    int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return doBuildTree(0, inorder.length);
    }

    public TreeNode doBuildTree(int inLeft, int inRight) {
        if (inLeft >= inRight || this.p>preorder.length-1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[this.p]);
        int index = inLeft; //index of root element in inorder array
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == preorder[this.p]) {
                index = i;
                break;
            }
        }
        this.p++;
        root.left = this.doBuildTree(inLeft, index);
        root.right = this.doBuildTree(index+1, inRight);
        return root;
    }

    @Test
    public void test() {
        ConstructBinaryTreefromPreorderandInorderTraversal sol = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] p = new int[]{1,2};
        int[] in = new int[]{1,2};
        TreeNode n = sol.buildTree(p, in);
        System.out.println("done");
    }
}
