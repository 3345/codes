package leetcode;

/**
 * Created by fyl on 7/18/19.
 */
public class MaximumAverageSubtree {
    double max;
    public double maximumAverageSubtree(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        this.avg(root);
        return this.max;
    }

    // return {avg_val, node_count}
    private double[] avg(TreeNode n) {
        if (n == null) {
            this.max = Math.max(this.max, 0);
            return new double[]{0,0};
        }

        double[] left = this.avg(n.left);
        double[] right = this.avg(n.right);
        double count = left[1] + right[1] + 1;
        double val = (left[0]*left[1] + right[0]*right[1] + n.val) / count;
        this.max = Math.max(val, max);
        return new double[]{val, count};
    }
}
