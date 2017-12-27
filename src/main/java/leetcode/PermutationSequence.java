package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fyl on 12/26/17.
 */
public class PermutationSequence {
    static Map<Integer, Integer> F_MAP = new HashMap<>();
    static {
        int cur = 1;
        for (int i = 1; i <= 9; i ++) {
            cur *= i;
            F_MAP.put(i, cur);
        }
    }

    public static int factorial(int n) {
        return F_MAP.get(n);
    }

    public String getPermutation(int n, int k) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }

        StringBuilder sb = new StringBuilder();
        helper(a, k, sb);
        return sb.toString();
    }

    public void helper(List<Integer> a, int k, StringBuilder sb) {
        if (k <= 1) {
            for (int i = 0; i < a.size(); i++) {
                sb.append(a.get(i));
            }
            return;
        }

        if (a.size() == 1) {
            sb.append(a.get(0));
            return;
        }

        int len = a.size();
        int rep = factorial(len) / len;
        int b = (k - 1)/ rep;
        sb.append(a.get(b));
        a.remove(b);
        helper(a, k - b * rep, sb);
    }

    @Test
    public void test() {
        int n = 3;
        int k = 4;
        System.out.print(getPermutation(n, k));
    }
}
