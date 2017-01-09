package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 1/8/17.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> mem = new HashMap<>();

        return solve(mem, nums, target);

    }

    public int solve(Map<Integer, Integer> mem, int[] nums, int target) {
        if (target <= 0) {
            return 0;
        }

        if (mem.containsKey(target)) {
            return mem.get(target);
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                sum += 1;
            } else if (nums[i] < target) {
                sum += solve(mem, nums, target - nums[i]);
            } else {
                break;
            }
        }

        mem.put(target, sum);

        return sum;
    }

    @Test
    public void t() {
        int[] nums = new int[] {1,2,3};
        System.out.println(combinationSum4(nums, 4));
    }
}
