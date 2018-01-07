package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by fyl on 1/7/18.
 */
public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return list;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (nums1[o1[0]] + nums2[o1[1]] == nums1[o2[0]] + nums2[o2[1]]) {
                return 0;
            }
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            q.offer(new int[]{i, 0});
        }

        for (int i = 0; i < k; i++) {
            if (q.peek() == null) {
                return list;
            }
            int[] top = q.poll();
            list.add(new int[]{nums1[top[0]], nums2[top[1]]});
            if (top[1] == nums2.length - 1) {
                continue;
            }
            q.offer(new int[]{top[0], top[1] + 1});
        }
        return list;
    }

    @Test
    public void test() {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 3;

        kSmallestPairs(nums1, nums2, k);
    }
}
