package leetcode;

/**
 * Created by fyl on 12/26/17.
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end)/2;

        if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }

        if (nums[mid - 1] == nums[mid]) {
            if (mid - 2 >= 0 && (mid - 2 - start + 1) % 2 != 0) {
                return helper(nums, start, mid - 2);
            } else {
                return helper(nums, mid + 1, end);
            }
        } else {
            if (mid + 2 < nums.length - 1 && (end - (mid + 2) + 1) % 2 != 0) {
                return helper(nums, mid + 1, end);
            } else {
                return helper(nums, start, mid - 1);
            }
        }
    }
}
