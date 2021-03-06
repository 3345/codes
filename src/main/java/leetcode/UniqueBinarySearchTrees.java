package leetcode;

import org.junit.Test;

/**
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
  \       /     /      / \      \
  3     2     1      1   3      2
 /     /       \                 \
2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public double numTrees(int n) {
        if (n == 0)
            return 0;

        double[] a = new double[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int sum = 0;
            for (int j = 1 ; j <= i; j ++) {
                sum += a[j - 1] * a[i - j];
            }
            a[i] = sum;
        }
        return a[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(15));
    }
}
