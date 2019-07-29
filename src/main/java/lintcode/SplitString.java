package lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public List<List<String>> splitString(String s) {
        // write your code here
        return dfs(s, 0);
    }

    public List<List<String>> dfs(String s, int i) {
        List<List<String>> res = new ArrayList<>();

        if (i > s.length() - 1) {
            res.add(new ArrayList<>());
            return res;
        }

        String one = s.substring(i, i + 1);
        List<List<String>> ones = dfs(s, i + 1);
        for (List<String> list : ones) {
            list.add(0, one);
        }
        res.addAll(ones);

        if (i < s.length() - 1) {
            String two = s.substring(i, i + 2);
            List<List<String>> twos = dfs(s, i + 2);
            for (List<String> list : twos) {
                list.add(0, two);
            }
            res.addAll(twos);
        }

        return res;
    }

    @Test
    public void test() {
        splitString("");
    }
}
