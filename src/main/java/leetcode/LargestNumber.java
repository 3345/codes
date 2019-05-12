package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 4/2/18.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Comparator<Integer> comparator = (o1, o2) -> {
            Stack<Integer> s1 = convertToStack(o1);
            Stack<Integer> s2 = convertToStack(o2);

            int last = 0;
            while(!s1.isEmpty() && !s2.isEmpty()) {
                int i1 = s1.pop();
                int i2 = s2.pop();
                last = i1;

                if (i1 != i2) {
                    return  i1 - i2;
                }
            }

            if (!s1.isEmpty()) {
                return s1.pop() - last;
            }
            if (!s2.isEmpty()) {
                return last - s2.pop();
            }

            return 0;
        };

        Queue<Integer> q = new PriorityQueue<>(comparator);
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        StringBuilder sb = new StringBuilder();

        Iterator<Integer> iter = q.iterator();
        while (iter.hasNext()) {
            sb.insert(0, iter.next());
        }
        return sb.toString();
    }

    private Stack<Integer> convertToStack(Integer i) {
        Stack<Integer> ret = new Stack<>();

        while(i > 0) {
            ret.push(i % 10);
            i /= 10;
        }

        return ret;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,1};
        this.largestNumber(nums);
    }

}
