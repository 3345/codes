package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fuyul on 12/20/2016.
 */
public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();

        Map<Integer, Integer> set = new HashMap<>();

        if (s.length() < 11) {
            return list;
        }

        int cur = 0;

        for (int i = 0; i < 10; i++) {
            cur = cur << 2;
            cur = cur | getByte(s.charAt(i));
        }

        set.put(cur, 0);
        int mask = 0b111111111111111111;

        for (int i = 10; i < s.length(); i++) {
            cur = cur & mask;
            cur = cur << 2;
            cur = cur | getByte(s.charAt(i));
            if (set.containsKey(cur)) {
                if (set.get(cur) == 0) {
                    list.add(s.substring(i + 1 - 10, i + 1));
                    set.put(cur, 1);
                }
            } else {
                set.put(cur, 0);
            }
        }

        return list;
    }

    public byte getByte(char c) {
        if (c == 'A') {
            return 0;
        }

        if (c == 'C') {
            return 1;
        }

        if (c == 'G') {
            return 2;
        }

        if (c == 'T') {
            return 3;
        }

        return -1;
    }

    @Test
    public void t() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        findRepeatedDnaSequences(s);
    }

}
