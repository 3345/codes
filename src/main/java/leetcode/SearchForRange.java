package leetcode;

import org.junit.Test;

/**
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForRange {
    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return helper(0, nums.length - 1);
    }

    private int[] helper(int start, int end) {
        int mid = (start + end) / 2;
        int[] ret = new int[2];

        if (start >= end) {
            if (nums[start] == target) {
                ret[0] = start;
                ret[1] = start;
                return ret;
            } else {
                ret[0] = -1;
                ret[1] = -1;
                return ret;
            }
        }

        if (nums[mid] == target) {
            ret[0] = findLeft(start, mid);
            ret[1] = findRight(mid, end);

        } else if (nums[mid] < target) {
            return helper(mid + 1, end);

        } else {
            return helper(start, mid - 1);
        }

        return ret;
    }


    private int findLeft(int start, int end) {
        if (start >= end) {
            if (nums[start] == target) {
                return start;
            } else {
                return  -1;
            }
        }

        int mid = (start + end) / 2;


        if (nums[mid] < target) {
            return findLeft(mid + 1, end);
        }

        if (nums[mid] == target) {
            int l = findLeft(start, mid - 1);
            if (l == -1) {
                return mid;
            } else {
                return l;
            }
        }

        return -1;
    }

    private int findRight(int start, int end) {
        if (start >= end) {
            if (nums[start] == target) {
                return start;
            } else {
                return  -1;
            }
        }

        int mid = (start + end) / 2;


        if (nums[mid] > target) {
            return findRight(start, mid - 1);
        }

        if (nums[mid] == target) {
            int r = findRight(mid + 1, end);
            if (r == -1) {
                return mid;
            } else {
                return r;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        int[] input = {5,7,7,8,8,10};
        SearchForRange sol = new SearchForRange();
        int[] ans = sol.searchRange(input, 8);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
