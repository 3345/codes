package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
// wrong!!!
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
           list.add(num[i]);
        }

        return solve(list);
    }

    public List<List<Integer>> solve(List<Integer> list) {
        if (list.size() == 0) {
            List<List<Integer>> l = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();
            l.add(ll);
            return l;
        }
        if (list.size() == 1) {
            List<List<Integer>> l = new ArrayList<>();
            List<Integer> ll = new ArrayList<>();
            ll.add(list.get(0));
            l.add(ll);
            return l;

        }

        Set<Integer> visited = new HashSet<>();

        int len = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i ++) {
            int removed = list.get(i);
            list.remove(i);
            if (!visited.contains(removed)) {
                visited.add(removed);

                List<List<Integer>> subAnswer = solve(list);
                for (List<Integer> l : subAnswer) {
                    l.add(0, removed);
                }

                ans.addAll(subAnswer);

            }
            list.add(i ,removed);
        }

        return ans;
    }




    @Test
    public void t1() {
        //1,1,0,0,1,-1,-1,1
        int[] arr = {1,1,2};
        List l = permuteUnique(arr);
        System.out.println(l);
    }

}
