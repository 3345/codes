package others;

import org.junit.Test;

import java.util.*;

/**
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null)
            return null;

        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> emptySet = new ArrayList<Integer>();
        result.add(emptySet);

        Set<Integer> visited = new HashSet<Integer>();
        int pointer = 0;

        for (int i = 0; i < num.length; i ++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();

            if (!visited.contains(num[i])) {
                visited.add(num[i]);
                for (List<Integer> list : result) {
                    List<Integer> listCopy = new ArrayList<Integer>(list);
                    listCopy.add(num[i]);
                    tmp.add(listCopy);
                }
            }

            else {
                for (int j = pointer; j < result.size(); j++) {
                    List<Integer> listCopy = new ArrayList<Integer>(result.get(j));
                    listCopy.add(num[i]);
                    tmp.add(listCopy);
                }
            }

            pointer = result.size();
            result.addAll(tmp);
        }

        return result;
    }

    @Test
    public void test() {
        int[] num = {};
        System.out.println(subsetsWithDup(num));
    }

}
