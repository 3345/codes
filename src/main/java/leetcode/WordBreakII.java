package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by yulai on 11/10/16.
 */
public class WordBreakII {
    Set<String> dict = new HashSet<>();
    String target = null;
    List<String> ans = new ArrayList<>();
    Map<String, List<String>> mem = new HashMap<>();
    int maxLen = 0;
    Set<Character> set = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String w : wordDict) {
            dict.add(w);
            maxLen = Math.max(maxLen, w.length());
        }

        this.target = s;
        dfs(0);
        return mem.getOrDefault(s, new ArrayList<>());
    }

    private void dfs(int start) {
        for (int i = start + 1; i < target.length() + 1 && i - start <= maxLen; i++) {
            String prefix = target.substring(start, i);
            String postfix = target.substring(i);
            if (dict.contains(prefix)) {
                if (postfix.isEmpty()) {
                    mem.putIfAbsent(prefix, new ArrayList<>());
                    mem.get(prefix).add(prefix);
                    return;
                }
                if (!mem.containsKey(postfix)) {
                    dfs(i);
                }
                if (mem.containsKey(postfix)) {
                    List<String> res = mem.getOrDefault(prefix + postfix, new ArrayList<>());
                    List<String> postfixRes = mem.get(postfix);
                    for (String r : postfixRes) {
                        res.add(prefix + " " + r);
                    }
                    mem.put(prefix + postfix, res);
                }
            }
        }
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaaaaaaaaaaaaa";
        List<String> d = Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"});
        wordBreak(s, d);
    }
}
