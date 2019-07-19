package lintcode;

import org.junit.Test;

/**
 * Created by fyl on 7/17/19.
 */
public class LastPositionOfTarget {
    public int lastPosition(int[] nums, int target) {
        // write your code here
        return find(nums, target, 0, nums.length);

    }

    private int find(int[] nums, int target, int s, int e) {
        if (e == s) {
            return -1;
        }
        if ((e-s) == 1) {
            if (nums[s] == target) {
                return s;
            } else {
                return -1;
            }
        }

        int mid = (s+e)/2;
        if (nums[mid] < target) {
            return this.find(nums, target, mid+1, e);
        }
        if (nums[mid] > target) {
            return this.find(nums, target, s, mid-1);
        }
        return this.find(nums, target, mid, e);
    }

    @Test
    public void test() {
        int[] input = new int[] {1,2,2,4,5,5};
        LastPositionOfTarget sol = new LastPositionOfTarget();
        sol.lastPosition(input, 2);

    }
}
