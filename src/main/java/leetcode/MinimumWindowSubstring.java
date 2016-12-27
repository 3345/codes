package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

        //char, occurrence
        Map<Character, Integer> occurrenceMap = new HashMap<>();

        Map<Character, List<Integer>> map = new HashMap<>();
        //position in s
        LinkedList<Integer> list = new LinkedList<>();

        int first = 0;
        int last = s.length() - 1;

        int visited = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        if (map.size() == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    return t.charAt(0) + "";
                } else {
                    return "";
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == -1) {
                    visited++;

                } else {
                    list.remove(map.get(c));

                }

                list.add(i);

                if (visited >= map.size()) {
                    if (list.getLast() - list.getFirst() < last - first) {
                        last = list.getLast();
                        first = list.getFirst();
                    }
                }

            }
        }

        if (visited < map.size()) {
            return "";
        } else {
            return s.substring(first, last + 1);
        }

    }
}
