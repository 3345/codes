package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 4/1/18.
 * [2,3,1,1,4]
 */
public class JumpGameII {
    int min = Integer.MAX_VALUE;
    int[] nums;

    public int jump(int[] nums) {
        this.nums = nums;

        helper(0, 0);
        return min;
    }

    public void helper(int cur, int steps) {
        if (cur == nums.length - 1) {
            this.min = Math.min(min, steps);
            return;
        }

        if (steps >= min) {
            return;
        }

        for (int i = 1; i <= nums[cur]; i++) {
            helper(cur + i, steps + 1);
        }
    }

    @Test
    public void test() {
        JumpGameII j = new JumpGameII();

        int[] a = {2,3,1,1,4};
        j.jump(a);
    }
}
