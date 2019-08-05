package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fyl on 7/25/19.
 */
public class RemoveInvalidParentheses {
    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int[] lr = this.calcMin(s);
        dfs(0, lr[0], lr[1], s);
        return result;
    }

    private void dfs(int start, int l, int r, String s) {
        if (r == 0 && l == 0) {
            if (isValid(s)) {
                this.result.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == ')' && r > 0) {
                dfs(i, l, r - 1, s.substring(0, i) + s.substring(i + 1));
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            } else if (s.charAt(i) == '(' && l > 0) {
                dfs(i, l - 1, r, s.substring(0, i) + s.substring(i + 1));
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            }
        }
    }

    private boolean isValid(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (r == 0) {
                    l++;
                } else {
                    return false;
                }

            } else if (s.charAt(i) == ')') {
                if (l == 0) {
                    return false;
                } else {
                    l--;
                }
            }
        }

        Map<Integer, AddAndSearchWord.Node> map = new HashMap<>();
        return true;
    }

    //l,r
    private int[] calcMin(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        return new int[]{l, r};
    }

    @Test
    public void test() {
        String s = "))";
        removeInvalidParentheses(s);
    }


}
