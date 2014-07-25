package others;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s and a dictionary of words dict, determine
 if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        if (len == 0)
            return false;
        boolean[] mem = new boolean[len];
        for (int i = 0; i < len; i ++) {
            for (int j = i; j >=0; j-- ) {
                boolean inDict = dict.contains(s.substring(j, i + 1));
                boolean ans;
                if (j == 0) {
                    ans = inDict;
                } else {
                    ans = inDict && mem[j - 1];
                }
                if (ans) {
                    mem[i] = true;
                    break;
                }
            }
        }
        return mem[len - 1];
    }

    @Test
    public void test() {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        boolean ans = wordBreak(s, dict);
        System.out.println(ans);
    }
}
