package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        if (num.length == 0)
            return null;
        List<Integer> numList = new ArrayList();
        for (int i = 0; i < num.length; i++) {
            numList.add(num[i]);
        }
        return solve(numList);

    }

    public List<List<Integer>> solve(List<Integer> num) {
        if (num.size() == 1)
            return Arrays.asList(Arrays.asList(num.get(0)));
        int rightMost = num.get(num.size() - 1);
        List<List<Integer>> lists = solve(num.subList(0, num.size() -1));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List list : lists) {
            for (int i = 0; i < list.size() + 1; i ++) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(i, rightMost);
                result.add(newList);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int [] a = {1,2,3};
        System.out.println(permute(a));
    }
}
