package leetcode;

/**
 * Created by fyl on 1/7/17.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        if (nums[0] >= s) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int rear = 0;
        int forward = 1;
        int cur = nums[0];


        while (forward < nums.length) {
            cur += nums[forward];
            if (cur >= s) {
                min = Math.min(min, forward - rear + 1);
                if (min == 1) {
                    return 1;
                }
            }

            while (forward > rear && cur >= s) {
                cur -= nums[rear];
                rear ++;
                if (cur >= s) {
                    min = Math.min(min, forward - rear + 1);
                    if (min == 1) {
                        return 1;
                    }
                }
            }

            forward++;
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }
}
