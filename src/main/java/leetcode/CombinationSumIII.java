package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/30/17.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List list = new ArrayList();
        helper(k, n, 1, list ,res);
        return res;
    }

    private boolean helper(int k, int target, int cur, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            if (k == 0) {
                res.add(new ArrayList<>(list));
            }
            return false;
        }

        if (cur > 9 || target < 0 || k < 0) {
            return false;
        }

        for (int i = cur; i < 10; i++) {
            list.add(i);
            boolean cont = helper(k-1, target - i, i + 1, list, res);
            list.remove(list.size() - 1);
            if (!cont) {
                break;
            }
        }

        return true;
    }

    @Test
    public void test() {
        combinationSum3(3, 15);
    }
}
