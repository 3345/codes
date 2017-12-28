package leetcode;

/**
 * Created by fyl on 12/28/17.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;

        TreeNode left = null;
        TreeNode right = null;
        if (mid > start) {
            left = helper(nums, start, mid - 1);
        }

        if (mid < end) {
            right = helper(nums, mid + 1, end);
        }

        TreeNode node = new TreeNode(nums[mid]);
        node.left = left;
        node.right = right;
        return node;
    }
}
