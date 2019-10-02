package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 8/1/19.
 */
public class FiFirstandLastPositionofElementinSortedArray {
    int first = -1;
    int last = -1;
    int target;
    int[] nums;

    public int[] searchRange(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        if (nums != null && nums.length > 0) {
            first(0,nums.length);
            if (first != -1) {
                last(0, nums.length);
            }
        }

        return new int[]{first,last};
    }

    public void first(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end)/2;
        if (nums[mid] < target) {
            first(mid+1, end);
        } else {
            if (nums[mid] == target) {
                first = mid;
            }
            first(start, mid);
        }
    }

    public void last(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end)/2;
        if (nums[mid] <= target) {
            if (nums[mid] == target) {
                last = mid;
            }
            last(mid+1, end);
        } else {
            last(start, mid);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{5,7,7,8,8,10};
        searchRange(nums, 8);
    }
}
