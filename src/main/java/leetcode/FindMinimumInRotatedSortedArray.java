package leetcode;

/**
 * Created by fyl on 12/26/17.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (start + end) / 2;

        if (nums[start] <= nums[mid]) {
            if (nums[mid + 1] <= nums[end]) {
                return Math.min(nums[start], nums[mid + 1]);
            } else {
                return helper(nums, mid + 1, end);
            }
        } else {
            return helper(nums, start, mid);
        }
    }
}
