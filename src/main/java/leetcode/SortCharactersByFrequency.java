package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 12/4/16.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], 1 + map.get(a[i]));
            } else {
                map.put(a[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<Character, Integer> j1 = (Map.Entry<Character, Integer>) o1;
                Map.Entry<Character, Integer> j2 = (Map.Entry<Character, Integer>) o2;

                if (j1.getValue() > j2.getValue()) {
                    return -1;
                } else if (j1.getValue() == j2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.add(entry);
        }


        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            Map.Entry<Character, Integer> ent = q.poll();
            for (int i = 0; i < ent.getValue(); i++) {
                sb.append(ent.getKey());
            }

        }

        return sb.toString();
    }

    @Test
    public void t() {
        String input = "raaeaedere";
        System.out.print(frequencySort(input));
    }

}
