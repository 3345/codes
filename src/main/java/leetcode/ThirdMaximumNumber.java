package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by fyl on 12/2/16.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(3);
        Set<Integer> visited = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            max = Math.max(max, nums[i]);
            if (q.size() < 3) {
                q.add(nums[i]);
            } else {
                if (nums[i] > q.peek()) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }

        if (q.size() != 3) {
            return max;
        }
        return q.peek();

    }

    @Test
    public void t() {
        int[] input = new int[] {2,2,3,1};
        int ans = thirdMax(input);
        System.out.print(ans);
    }
}
