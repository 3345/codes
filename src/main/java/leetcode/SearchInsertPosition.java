package leetcode;

import org.junit.Test;

/**
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0 */
public class SearchInsertPosition {
    int[] nums;
    int target;

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return bs(0, nums.length - 1);
    }

    public int bs(int start, int end) {
        if (start >= end) {
            if (nums[start] >= target) {
                return start;

            } else {
                return start + 1;
            }
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return bs(mid + 1, end);
        } else {
            return bs(start, mid - 1);
        }
    }

    @Test
    public void test() {
        SearchInsertPosition sol = new SearchInsertPosition();
        int[] input = {1};
        System.out.println(sol.searchInsert(input, 1));
    }
}
