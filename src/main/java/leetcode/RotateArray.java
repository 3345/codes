package leetcode;

import org.junit.Test;

/**
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = k % nums.length;

        if (n == 0) {
            return;
        }

        reverse(nums, 0 , nums.length - 1);

        reverse(nums, 0, n - 1);

        reverse(nums, n, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {
        int start = s;
        int end = e;

        while (end > start) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++; end --;
        }
    }

    @Test
    public void test() {
        int[] input = {1,2,3,4,5,6,7};
        rotate(input, 3);

        System.out.println("sad");
    }
}
