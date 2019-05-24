package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by fyl on 5/23/19.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        PriorityQueue<Long> q = new PriorityQueue<>();
        q.offer(1L);

        int count = 0;
        long ret = 0;
        while (count < n) {
            long r = q.poll();
            if (r == ret) {
                continue;
            }
            ret = (int)r;
            count++;
            for (int i = 0; i < primes.length; i++) {
                q.offer(ret * primes[i]);
            }
        }
        return (int) ret;

    }


    @Test
    public void test() {
        int n = 12;
        int[] primes = new int[]{2, 7, 13, 19};
        SuperUglyNumber sol = new SuperUglyNumber();
        int i = sol.nthSuperUglyNumber(n, primes);
        System.out.print(i);
    }
}
