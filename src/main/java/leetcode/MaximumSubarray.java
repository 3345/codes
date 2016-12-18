package leetcode;

/**
 * Created by fyl on 12/18/16.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur+= nums[i];
            max = Math.max(cur, max);
            cur = Math.max(cur, 0);
        }

        return max;
    }
}
