package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fyl on 5/29/19.
 */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return ans;
        }
        int wordCount = words.length;
        int wordLen = words[0].length();
        int sLen = s.length();
        int l = 0, r = 0, counter = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> m = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }


        while (l <= sLen - wordCount * wordLen && r < sLen) {
            String nextWord = s.substring(r, r + wordLen);
            if (map.containsKey(nextWord) && m.getOrDefault(nextWord, 0) < map.get(nextWord)) {
                m.put(nextWord, m.getOrDefault(nextWord, 0) + 1);
                counter++;
                r += wordLen;
                if (counter == wordCount) {
                    ans.add(l);
                    String evict = s.substring(l, l + wordLen);
                    m.put(evict, m.get(evict) - 1);
                    if (l > sLen - 1) {
                        break;
                    }
                    l++;
                    r = l;
                    counter = 0;
                    m = new HashMap<>();
                }
            } else {
                l++;
                r = l;
                m = new HashMap<>();
                counter = 0;
            }
        }
        return ans;
    }


    @Test
    public void test() {
//
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","good"};
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo","bar"};
//        String s = "aaaaaaaa";
//        String[] words = new String[]{"aa","aa", "aa"};
//        String s = "mississippi";
//        String[] words = new String[]{"si","is"};
        String s = "a";
        String[] words = new String[]{"a"};


        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.print(sol.findSubstring(s, words));

    }

    @Test
    public void t1() {
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar", "foo", "the"};

        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.print(sol.findSubstring(s, words));
    }

    @Test
    public void t2() {
        String s = "mississippi";
        String[] words = new String[]{"is"};

        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.print(sol.findSubstring(s, words));
    }

    @Test
    public void t3() {
        String s = "ababaab";
        String[] words = new String[]{"ab", "ba", "ba"};

        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.print(sol.findSubstring(s, words));
    }

    @Test
    public void t4() {
        String s = "abaababbaba";
        String[] words = new String[]{"ab", "ba", "ab", "ba"};

        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.print(sol.findSubstring(s, words));
    }

}
