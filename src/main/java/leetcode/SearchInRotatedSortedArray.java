package leetcode;

import org.junit.Test;

/**
 * Created by fuyul on 12/25/2016.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return  -1;
        }

        return doSearch(nums, target, 0, nums.length - 1);
    }

    public int doSearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            if (nums[start] == nums[mid]) {
                return doSearch(nums, target, mid + 1, end);
            } else if(nums[start] > nums[mid]) {
                if (nums[start] == target) {
                    return start;
                }

                return doSearch(nums, target, start, mid - 1);
            } else {
                if (nums[start] == target) {
                    return start;
                }

                if (nums[start] > target) {
                    return doSearch(nums, target, mid + 1, end);
                } else {
                    return doSearch(nums, target, start, mid - 1);
                }
            }
        }

        if (nums[mid] < target) {
            if (nums[start] > nums[mid]) {
                if (nums[start] > target) {
                    return doSearch(nums, target, mid + 1, end);
                }

                if (nums[start] == target) {
                    return start;
                }

                if (nums[start] < target) {
                    return doSearch(nums, target, start, mid - 1);
                }
            } else if (nums[start] == nums[mid]) {
                return doSearch(nums, target, mid + 1, end);
            } else if (nums[start] < nums[mid]) {
                if (nums[start] == target) {
                    return start;
                }
                return doSearch(nums, target, mid + 1, end);
            }
        }

        return -1;
    }

    @Test
    public void t() {
        int[] arr = new int[] {4,5,6,7,0,1,2};

        int i = search(arr, 2);

        System.out.println(i);
    }


}
