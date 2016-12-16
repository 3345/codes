package leetcode;

import java.util.*;

/**
 * Created by fyl on 12/15/16.
 */
public class ShortestWordDistanceII {
    public class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    map.get(words[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(words[i], list);
                }
            }
        }

        public int shortest(String word1, String word2) {
            if (map.size() == 2) {
                return 1;
            }

            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int i1 = 0;
            int i2 = 0;

            int min = Integer.MAX_VALUE;

            while (i1 < l1.size() && i2 < l2.size() ) {
                int v1 = l1.get(i1);
                int v2 = l2.get(i2);

                min = Math.min(min, Math.abs(v1 - v2));

                if (v1 < v2) {
                    i1++;
                } else {
                    i2++;
                }
            }

            return min;

        }
    }

}
