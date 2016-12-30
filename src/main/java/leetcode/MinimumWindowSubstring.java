package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

/**
 * Created by fyl on 12/26/16.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t == null || s == null | t.length() == 0 || s.length() == 0) {
            return "";
        }

        if (t.length() > s.length()) {
            return "";
        }

        if (t.length() == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    return t.charAt(0) + "";
                }
            }

            return "";
        }

        //char, occurrence
        Map<Character, Integer> occurrenceMap = new HashMap<>();

        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        //position in s
        LinkedList<Integer> list = new LinkedList<>();

        int first = 0;
        int last = s.length() - 1;

        int visited = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (occurrenceMap.containsKey(c)) {
                occurrenceMap.put(c, occurrenceMap.get(c) + 1);
            } else {
                occurrenceMap.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c).size() < occurrenceMap.get(c)) {
                    visited++;
                } else {
                    list.remove(map.get(c).removeFirst());
                }

            } else if (occurrenceMap.containsKey(c)){
                LinkedList<Integer> l = new LinkedList<>();
                map.put(c,l);
                visited++;
            } else {
                continue;
            }

            map.get(c).add(i);
            list.add(i);

            if (visited >= t.length()) {
                if (list.getLast() - list.getFirst() < last - first) {
                    last = list.getLast();
                    first = list.getFirst();
                }
            }
        }

        if (visited < t.length()) {
            return "";
        } else {
            return s.substring(first, last + 1);
        }

    }

    @Test
    public void t() {
        System.out.println(minWindow("abc", "ab"));
    }
}
