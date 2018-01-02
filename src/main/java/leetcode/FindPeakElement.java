package leetcode;

import org.junit.Test;

/**
 * Created by fuyul on 1/1/2018.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        return helper(nums, 0 ,nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return start;
        }

        int mid = (start + end)/2;
        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length-1 || nums[mid] > nums[mid + 1])) {
            return mid;
        }

        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return helper(nums, start, mid - 1);
        }

        if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
            return helper(nums, mid + 1, end);
        }

        return -1;
    }

    @Test
    public void test() {
        int[] a = {1,2};
        findPeakElement(a);
    }
}
