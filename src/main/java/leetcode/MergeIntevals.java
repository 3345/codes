package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by fyl on 5/22/19.
 */
public class MergeIntevals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] top = stack.peek();
            if (top[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            } else {
                if (top[1] < intervals[i][1]) {
                    stack.pop();
                    stack.push(new int[]{top[0], intervals[i][1]});
                }
            }
        }
        int[][] ret = new int[stack.size()][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.get(i);
        }
        return ret;
    }

    @Test
    public void test(){
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        merge(input);
    }
}
