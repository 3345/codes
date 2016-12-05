package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fyl on 12/4/16.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        list.add(1);

        if (rowIndex == 0) {
            return list;
        }

        list.add(1);


        if (rowIndex == 1) {
            return list;
        }


        List<Integer> prev = list;

        for (int i = 1; i < rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);

            for (int j = 0; j + 1 < prev.size(); j ++) {
                cur.add(prev.get(j) + prev.get(j+1));
            }
            cur.add(1);
            prev = cur;
        }

        return prev;
    }
}
