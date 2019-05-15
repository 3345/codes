package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A'] = count[tasks[i] - 'A'] + 1;
        }

        Queue<Integer> q = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                q.offer(count[i]);
            }
        }

        int ret = 0;
        while (!q.isEmpty()) {
            List<Integer> remain = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (q.isEmpty()) {
                    break;
                }

                remain.add(q.poll() - 1);
            }
            for (int r : remain) {
                if (r > 0) {
                    q.offer(r);
                }
            }
            int cycle = q.isEmpty() ? remain.size() : n + 1;
            ret += cycle;
        }

        return ret;
    }

    @Test
    public void t() {
        TaskScheduler sol = new TaskScheduler();
        char[] chars = new char[]{'A','A','A','B','B','B'};
        sol.leastInterval(chars,2);

    }
}
