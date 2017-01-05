package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 11/27/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();

        if (strs == null) {
            return lists;
        }

        for (String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);

            String id = new String(a);
            if (map.containsKey(id)) {
                lists.get(map.get(id)).add(s);
            } else {
                map.put(id, map.size());
                lists.add(new ArrayList<>(Arrays.asList(s)));
            }
        }

        return lists;

    }


}
