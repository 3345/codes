package leetcode;

/**
 * Created by fyl on 12/26/17.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return helper(nums, 0, nums.length - 1, target);
    }

    public boolean helper(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target;
        }

        int mid = (start + end) / 2;

        if (nums[start] == target || nums[mid] == target || nums[mid + 1] == target || nums[end] == target) {
            return true;
        }

        if (nums[start] < nums[mid] && nums[start] < target && target < nums[mid]) {
            return helper(nums, start, mid, target);
        } else if (nums[mid + 1] < nums[end] && nums[mid + 1] < target && target < nums[end]) {
            return helper(nums, mid + 1, end, target);
        } else if (nums[start] > nums[mid]) {
            return helper(nums, start, mid, target);
        } else if (nums[mid + 1] > nums[end]) {
            return helper(nums, mid + 1, end, target);
        } else if (nums[start] == nums[mid] && nums[mid+ 1] == nums[end] ){
            return helper(nums, start, mid, target) || helper(nums, mid + 1, end, target);
        } else {
            return false;
        }
    }
}
