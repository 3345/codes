package leetcode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by fyl on 5/27/19.
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i).get(0);
            max = Math.max(max, n);
            q.offer(new Node(n, 0, i));
        }

        res[0] = q.peek().val;
        res[1] = max;

        while (!q.isEmpty()) {
            Node pop = q.poll();
            if (pop.index == nums.get(pop.row).size() - 1) {
                break;
            }
            int num = nums.get(pop.row).get(pop.index + 1);
            Node n = new Node(num, pop.index + 1, pop.row);
            q.offer(n);
            max = Math.max(max, num);
            if (max - q.peek().val < res[1] - res[0]) {
                res[0] = q.peek().val;
                res[1] = max;
            }
        }

        return res;
    }

    public class Node implements Comparable {
        Integer val;
        int index;
        int row;

        @Override
        public int compareTo(Object o) {
            Node that = (Node)o;
            return this.val - that.val;
        }

        public Node(Integer val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }
}
