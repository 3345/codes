package others;

import org.junit.Test;

import java.util.*;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
// wrong!!!
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num.length == 0)
            return null;
        List<Integer> numList = new ArrayList();
        for (int i = 0; i < num.length; i++) {
            numList.add(num[i]);
        }
        Set<Integer> visited = new HashSet<Integer>();
        return solve(numList, visited);

    }

    public List<List<Integer>> solve(List<Integer> num, Set<Integer> visited) {
        if (num.size() == 1) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>(Arrays.asList(num.get(0))));
            visited.add(num.get(0));
            return result;
        }

        int rightMost = num.get(num.size() - 1);


        List<List<Integer>> lists = solve(num.subList(0, num.size() - 1), visited);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (List<Integer> list : lists) {
            if (!visited.contains(rightMost)) {
                for (int i = 0; i < list.size() + 1; i++) {
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(i, rightMost);
                    result.add(newList);
                }
            } else {
                list.add(rightMost);
                result.add(list);
            }
        }
        visited.add(rightMost);
        return result;
    }

    @Test
    public void t1() {
        //1,1,0,0,1,-1,-1,1
        int[] arr = {1,1,0,0,1,-1,-1,1};
        List l = permuteUnique(arr);
        System.out.println(l);
    }

}
