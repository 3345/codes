package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fyl on 12/30/17.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (candidates == null) {
            return res;
        }

        Arrays.sort(candidates);
        helper(candidates, target, 0, list, res);

        return res;
    }

    private boolean helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return false;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return false;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            boolean cont = helper(candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
            if (!cont) {
                break;
            }
        }

        return true;
    }

    @Test
    public void test() {
        int[] a = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(a, target);
    }
}
