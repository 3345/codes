package leetcode;

import org.junit.Test;

import java.util.*;

/**
 Given a set of distinct integers, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */
public class Subsets {
    public List<List<Integer>> subsets(int[] s) {
        Arrays.sort(s);
        return solve(s, 0, s.length - 1);

    }

    public LinkedList<List<Integer>> solve(int[] a, int start, int end) {
        if (start == end) {
            List<Integer> nullSet = new ArrayList<Integer>();
            List<Integer> oneSet = new ArrayList<Integer>(Arrays.asList(a[start]));

            LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
            list.add(nullSet);
            list.add(oneSet);
            return list;
        }

        Integer right = a[end];
        LinkedList<List<Integer>> leftList = solve(a, start, end - 1);
        LinkedList<List<Integer>> copy = copy(leftList);
        for (List<Integer> subset : copy) {
            subset.add(right);
        }
        leftList.addAll(copy);
        return leftList;
    }

    private LinkedList<List<Integer>> copy(List<List<Integer>> s) {
        LinkedList<List<Integer>> d = new LinkedList<List<Integer>>();
        for (List<Integer> subList : s) {
            List<Integer> l = new ArrayList<Integer>();
            for (Integer i : subList) {
                l.add(i);
            }
            d.add(l);
        }
        return d;
    }

    @Test
    public void test1() {
        int [] s = {1,2};
        List list = subsets(s);
    }
}
