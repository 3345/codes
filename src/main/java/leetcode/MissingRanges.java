package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/11/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if (nums == null) {
            return list;
        }

        if (nums.length==0) {
            if (lower == upper) {
                list.add(lower + "");
            } else {
                list.add(lower + "->" + upper);
            }

            return list;
        }

        int start;
        int end = lower;


        for (int i = 0; i < nums.length; i ++) {
            start = end;
            end = nums[i];

            if (i == 0) {
                if (nums[0] == lower + 1) {
                    list.add(lower + "");
                } else if (nums[0] > lower + 1) {
                    list.add(lower + "->" + (nums[0] - 1));
                }
            } else {
                if (new Long(end) - new Long(start) > 1) {
                    int ms = start + 1;
                    int me = end - 1;
                    if (ms == me) {
                        list.add(ms + "");
                    } else {
                        list.add(ms + "->" + me);
                    }
                }

            }


            if (i == nums.length - 1) {
                if (nums[i] == upper - 1) {
                    list.add(upper + "");
                } else if (nums[i] < upper - 1) {
                    list.add(nums[i]+ 1 + "->" + upper);
                }
            }

        }

        return list;
    }

    @Test
    public void t() {
        int[] nums = new int[] {-2147483648,2147483647};
        int lower = -2147483648;
        int upper = 2147483647;
        findMissingRanges(nums, lower, upper);
    }

}
