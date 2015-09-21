package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */
public class CombinationSum {
    int[] candidates;
    int target;
    List<List<Integer>> result;
    List<Integer> currentList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<List<Integer>>();
        currentList = new ArrayList<Integer>();
        this.candidates = candidates;
        this.target = target;
        comb(0, 0);

        return result;
    }

    public void comb(int index, int currentSum) {
        if (currentSum == target) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.addAll(currentList);
            result.add(ans);
            return;
        }

        if (currentSum + candidates[index] > target) {
            return;
        }

        currentList.add(candidates[index]);
        comb(index, currentSum + candidates[index]);
        currentList.remove(currentList.size() - 1);

        for (int i = index + 1; i < candidates.length; i ++) {
            if (candidates[i] == candidates[index])
                continue;

            currentList.add(candidates[i]);
            comb(i, currentSum + candidates[i]);
            currentList.remove(currentList.size() - 1);
        }
    }

    @Test
    public void test() {
        CombinationSum combinationSum = new CombinationSum();
        int[] a = {2,3,6,7};
        List<List<Integer>> result = combinationSum.combinationSum(a, 7);
        Gson gson = new Gson();
        System.out.print(gson.toJson(result));
    }
}
