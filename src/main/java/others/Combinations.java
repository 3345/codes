package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i ++) {
            list.add(i);
        }
        return comb(k, list);
    }

    public List<List<Integer>> comb(int k, List<Integer> list) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (k > list.size())
            return result;
        if (k == 1) {
            for (Integer i : list) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                result.add(a);
            }
            return result;
        }
        for (int i = 0; i <= list.size() - k; i ++) {
            List<List<Integer>> prevResult = comb(k - 1, list.subList(i + 1, list.size()));
            for (List<Integer> subResult : prevResult) {
                subResult.add(0, list.get(i));
                result.add(subResult);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        System.out.println(combine(5,2));
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,1,2,2));
        System.out.println(comb(2, list));
    }

}
