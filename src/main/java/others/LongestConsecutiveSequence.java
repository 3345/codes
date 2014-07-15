package others;

import org.junit.Test;

import java.util.*;

/**
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int longest = 0;
        Map<Integer, LinkedList<Integer>> table = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < num.length; i ++) {
            if (table.containsKey(num[i]))
                continue;

            LinkedList<Integer> small = table.get(num[i] - 1);
            LinkedList<Integer> big = table.get(num[i] + 1);

            if (big == null && small == null) {
                LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(num[i]));
                table.put(num[i], list);
                longest = Math.max(longest, 1);
                continue;
            }

            if (big != null && small != null) {
                small.add(num[i]);
                small.addAll(big);
                table.put(num[i] + 1, small);
                table.put(num[i], small);
                longest = Math.max(longest, small.size());
                continue;
            }

            if (big != null) {
                big.add(num[i]);
                table.put(num[i], big);
                longest = Math.max(longest, big.size());
            }

            if (small != null) {
                small.add(num[i]);
                table.put(num[i], small);
                longest = Math.max(longest, small.size());
            }
        }
        return longest;
    }

    @Test
    public void t() {
        int[] a = {-1,1,0};
        System.out.println(longestConsecutive(a));
    }

}
