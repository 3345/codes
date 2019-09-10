package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] tree) {
        int s = 0; int e = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (e < tree.length && s <= e) {
            if (map.size() < 3) {
                map.put(tree[e], map.getOrDefault(tree[e],0)+1);
                if (map.size() < 3)  max = Math.max(max, e-s+1);
                e++;
            } else {
                while (map.size() > 2) {
                    map.put(tree[s], map.get(tree[s]) - 1);
                    if (map.get(tree[s]) == 0) {
                        map.remove(tree[s]);
                    }
                    s++;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] a = new int[]{5,9,0,9,6,9,6,9,9,9};
        totalFruit(a);
    }
}
