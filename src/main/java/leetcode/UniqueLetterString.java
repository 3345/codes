package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UniqueLetterString {
//    public int uniqueLetterString(String s) {
//
//    }

    @Test
    public void test() {
        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
}
