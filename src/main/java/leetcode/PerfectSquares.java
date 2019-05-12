package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 4/2/18.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }

        List<Integer> squares = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i*i <= n) {
                squares.add(i*i);
            } else {
                break;
            }
        }

        Queue<Integer> numQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        numQ.offer(n);
        levelQ.offer(1);

        while (!numQ.isEmpty()) {
            int num = numQ.poll();
            int level = levelQ.poll();

            if (visited.contains(num)) {
                continue;
            }

            visited.add(num);

            if (squares.contains(num)) {
                return level;
            }

            Iterator<Integer> iter = squares.iterator();
            while(iter.hasNext()) {
                int i = iter.next();
                if (i < num) {
                    numQ.offer(num - i);
                    levelQ.offer(level + 1);
                } else {
                    break;
                }
            }
        }

        return 0;
    }

    @Test
    public void test() {
        this.numSquares(7168);
    }
}
