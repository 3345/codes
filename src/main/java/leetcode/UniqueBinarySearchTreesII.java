package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {

        return doGenerate(1, n);
    }

    /*
    inclusive
     */
    public List<TreeNode> doGenerate(int j, int k) {
        List<TreeNode> result = new ArrayList<>();

        if (j == k) {
            result.add(new TreeNode(j));
        } else if (j > k) {
            //empty list
            result.add(null);
        } else {

            for (int i = j; i < k + 1; i++) {
                List<TreeNode> lefts = doGenerate(j, i - 1);
                List<TreeNode> rights = doGenerate(i + 1, k);

                if (!lefts.isEmpty() && !rights.isEmpty()) {
                    for (TreeNode left : lefts) {
                        for (TreeNode right : rights) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            result.add(root);
                        }
                    }
                }

                if (lefts.isEmpty()) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.right = right;
                        result.add(root);
                    }
                }

                if (rights.isEmpty()) {
                    for (TreeNode left : lefts) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        result.add(root);
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        List<TreeNode> ans = generateTrees(0);
        System.out.println();
    }
}
