package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by yulai on 11/10/16.
 */
public class WordBreakII {
    Set<String> dict = new HashSet<>();
    Map<String, List<String>> res = new HashMap<>();
    String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        for (String word : wordDict) {
            this.dict.add(word);
        }
        recur(0);
        return this.res.get(s);

    }

    public void recur(int first) {
        if (first > s.length() - 1) {
            return;
        }

        for (int i = first; i < s.length(); i++) {
            String prefix = s.substring(first, i + 1);
            if (!this.dict.contains(prefix)) {
                continue;
            }
            String postfix = s.substring(i + 1);
            List<String> result = new ArrayList<>();
            if (postfix.isEmpty()) {
                result.add(prefix);
                this.res.put(prefix, result);
                return;
            }
            if (!res.containsKey(postfix)) {
                recur(i + 1);
            }
            for (String postfixRes : res.get(postfix)) {
                result.add(prefix + " " + postfixRes);
            }
            this.res.put(prefix, result);
        }
    }

    @Test
    public void test() {
        String s = "catsanddog";
        List<String> d = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        wordBreak(s, d);
    }
}
