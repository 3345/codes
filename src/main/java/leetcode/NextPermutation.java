package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/25/17.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int start = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int index = findMinGreaterThan(nums, i, nums.length - 1,  nums[i -1]);
                int temp = nums[index];
                nums[index] = nums[i - 1];
                nums[i - 1] = temp;
                start = i;
                break;
            }
        }

        reverse(nums, start, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length - 1) {
            return;
        }

        if (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            reverse(nums, start + 1, end - 1);
        }
    }

    //return index
    private int findMinGreaterThan(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return start;
        }
        if (start == end - 1) {
            if (nums[end] > target) {
                return end;
            } else {
                return start;
            }
        }

        int mid = (start + end) / 2;

        if(nums[mid] <= target) {
            return findMinGreaterThan(nums, start, mid - 1, target);
        } else {
            return findMinGreaterThan(nums, mid, end, target);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,3,2};
        NextPermutation sol = new NextPermutation();
        sol.nextPermutation(nums);
        System.out.print("");
    }
}
