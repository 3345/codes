package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fyl on 12/28/17.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right --;
                }
                if (left >= right) {
                    break;
                }

                int val = target - nums[i] - nums[left] - nums[right];

                if (Math.abs(val) < Math.abs(min)) {
                    min = val;
                }

                if (val == 0) {
                    return target;
                }

                if (val > 0) {
                    left++;
                }

                if (val < 0) {
                    right--;
                }
            }
        }

        return target - min;
    }

    @Test
    public void test() {
        int[] a ={-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};

        threeSumClosest(a, 0);
    }
}
