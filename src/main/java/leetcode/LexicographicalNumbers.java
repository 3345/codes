package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 1/6/18.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (true) {
            int num = list.get(list.size() - 1);
            int i1 = num * 10;
            if (i1 <= n) {
                list.add(i1);
            } else {
                i1 = num + 1;
                if (i1 <= n && (i1 % 10 != 0)) {
                    list.add(i1);
                } else {
                    i1 = num / 10 + 1;
                    while (i1 != 0 && (i1 % 10 != 0)) {
                        i1 /= 10;
                    }
                    if (i1 == 0 || i1 == 1) {
                        return list;
                    }
                    list.add(i1);
                }
            }
        }
    }

    @Test
    public void test() {
        lexicalOrder(4999);
    }
}
