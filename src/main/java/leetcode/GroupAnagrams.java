package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 11/27/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Id, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i ++) {
            String s = strs[i];
            Id id = new Id(s);

            if (map.containsKey(id)) {
                map.get(id).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(id, list);

            }
        }

        List<List<String>> ret = new ArrayList<>();
        for (Id key : map.keySet()) {
            ret.add(map.get(key));
        }

        return ret;

    }

    public class Id {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;

        public Id(String s) {
            char[] a = s.toCharArray();

            len = a.length;

            for (int i = 0; i < a.length; i++) {
                char c = a[i];
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }



        @Override
        public int hashCode() {
            int result = map != null ? map.hashCode() : 0;
            result = 31 * result + len;
            return result;
        }


        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Id)) {
                return false;
            }

            Id that = (Id) o;

            if (that.len != this.len) {
                return false;
            }

            Map<Character, Integer> thatMap = that.map;

            for (Map.Entry<Character, Integer> entry : this.map.entrySet()) {
                Character k = entry.getKey();
                Integer v = entry.getValue();

                if (!thatMap.containsKey(k)) {
                    return false;
                } else {
                    if (!v.equals(thatMap.get(k))) {
                        return false;
                    }
                }
            }

            return true;
        }

    }

    @Test
    public void t0() {
        String[] input = {"", ""};

        groupAnagrams(input);
    }
}
