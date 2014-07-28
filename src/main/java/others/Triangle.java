package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null)
            return 0;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> below = triangle.get(i+1);
            for (int j = 0; j < row.size(); j++) {
                int element = row.remove(j);
                row.add(j, element + Math.min(below.get(j), below.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row0 = new ArrayList<Integer>(Arrays.asList(1));
        List<Integer> row1 = new ArrayList<Integer>(Arrays.asList(2,3));
        triangle.add(row0); triangle.add(row1);

        System.out.println(minimumTotal(triangle));
    }
}
