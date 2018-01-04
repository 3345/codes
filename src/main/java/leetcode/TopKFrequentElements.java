package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //[num, freq]
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return 0;
            }

            return o1[1] - o2[1] > 0 ? -1 : 1;
        });
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map.entrySet().forEach(entry -> q.add(new int[]{entry.getKey(), entry.getValue()}));

        for (int i = 0; i < k; i ++) {
            list.add( q.poll()[0]);
        }
        return list;
    }

    @Test
    public void test() {
        int[] a = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(null, k);
    }

}
