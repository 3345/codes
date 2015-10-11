package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Created by yulai on 10/10/15.
 */
public class LetterCombinationsPhoneNumber {
    static Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }


    List<String> ans;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 1) {
            return new ArrayList<>();
        }

        dfs(digits, 0, Arrays.asList(""));
        return ans;
    }

    public void dfs(String digits, int index, List<String> current) {
        if (index > digits.length() - 1) {
            ans = current;
            return;
        }

        List<String> next = new ArrayList<>();
        Character key = digits.charAt(index);

        for (String word : current) {
            for (Character c : map.get(key)) {
                next.add(word + c);
            }
        }

        dfs(digits, ++ index, next);
    }

    @Test
    public void test() {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }
}
