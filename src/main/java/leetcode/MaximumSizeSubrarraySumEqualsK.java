package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/24/2017.
 */
public class MaximumSizeSubrarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        //sum index map
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curSum = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            map.putIfAbsent(curSum, i);
            len = Math.max(len, i - map.getOrDefault(curSum - k, i));
        }

        return len;
    }
}
