package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> m = new HashMap<>();
        int[] psum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            psum[i+1] = psum[i]+nums[i];
            m.put(psum[i+1], i+1);
        }

        for (int i = 0; i < psum.length-1;i++) {
            if (psum.length - 1 - i < max) {
                break;
            }
            int target = k + psum[i];
            if (!m.containsKey(target)) continue;
            max = Math.max(max, m.get(target) -i);
        }

        return max;

    }

    @Test
    public void test() {
        int[] nums = new int[]{-1};
        int k = -1;
        maxSubArrayLen(nums, k);
    }
}
