package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 12/3/17.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //sum : occurence
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int total = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            total += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}
