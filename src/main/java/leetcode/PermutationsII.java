package leetcode;

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
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }

        List<LinkedList<Integer>> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(num[0]);
        for (int i = 1; i < num.length; i++) {
            for(LinkedList<Integer> ll : list) {
                list.remove(ll);
            }
        }

    }




    @Test
    public void t1() {
        //1,1,0,0,1,-1,-1,1
        int[] arr = {1,1,1,0,0,0};
        List l = permuteUnique(arr);
        System.out.println(l);
    }

}
