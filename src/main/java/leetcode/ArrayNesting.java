package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fyl on 3/25/18.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }

            int count = 0;
            int cur = i;
            while (!set.contains(cur)) {
                set.add(cur);
                cur = nums[cur];
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
