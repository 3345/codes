package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fuyul on 1/25/2017.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int key = 0;
        int count = 0;
        int len = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                len += count;
                count = 1;
                key = nums[i];
                if (!q.isEmpty()) {
                    nums[q.poll()] = nums[i];
                    q.offer(i);
                }
            } else {
                if (count > 1) {
                    q.offer(i);
                } else {
                    count++;
                    if (!q.isEmpty()) {
                        nums[q.poll()] = nums[i];
                        q.offer(i);
                    }
                }
            }
        }

        len += count;
        return len;

    }
}
