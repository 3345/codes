package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        if (k < 1 || s.length() < 2) {
            return s;
        }
        char[] a = s.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < a.length; i++) {
            count[a[i]] = count[a[i]] + 1;
        }

        Queue<Tuple> q = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                Tuple t = new Tuple((char) i, count[i]);
                q.offer(t);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            List<Tuple> l = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (q.isEmpty()) {
                    break;
                }
                Tuple t = q.poll();
                t.ct = t.ct - 1;
                l.add(t);
                sb.append(t.ch);
            }

            for (Tuple t : l) {
                if (t.ct > 0) {
                    q.offer(t);
                }
            }

            if (l.size() < k && !q.isEmpty()) {
                return "";
            }
        }

        return sb.toString();
    }

    public class Tuple implements Comparable {
        Character ch;
        Integer ct;

        public Tuple(Character ch, Integer ct) {
            this.ch = ch;
            this.ct = ct;
        }

        @Override
        public int compareTo(Object o) {
            Tuple t = (Tuple)o;
            int diff =  t.ct - this.ct;
            if (diff != 0) {
                return diff;
            }
            return this.ch - t.ch;
        }
    }

    @Test
    public void test() {
        RearrangeStringkDistanceApart sol = new RearrangeStringkDistanceApart();
        String s = sol.rearrangeString("a", 2);
        System.out.println(s);
    }
}
