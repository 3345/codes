package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/28/17.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        return helper(nums, 0, nums.length - 1);
    }

    public List<String> helper(int[] nums, int start, int end) {
        List<String> list = new ArrayList<>();
        if (start == end) {
            list.add(nums[start] + "");
            return list;
        }

        if (nums[end] - nums[start] == end - start) {
            list.add(nums[start] + "->" + nums[end]);
            return list;
        }

        int mid = (start + end) / 2;

        List<String> left = helper(nums, start, mid);
        List<String> merged = new ArrayList<>();
        if (mid + 1 <= end) {
            List<String> right = helper(nums, mid + 1, end);
            int leftMax = getRightBound(left.get(left.size() - 1));
            int rightMin = getLeftBound(right.get(0));
            if (rightMin - leftMax == 1) {
                String ms = getLeftBound(left.get(left.size() - 1)) + "->" + getRightBound(right.get(0));
                merged.addAll(left.subList(0, left.size() - 1));
                merged.add(ms);
                merged.addAll(right.subList(1, right.size()));
            } else {
                merged.addAll(left);
                merged.addAll(right);
            }
        } else {
            merged.addAll(left);
        }

        return merged;
    }

    private int getRightBound(String range) {
        String[] s = range.split("->");
        return Integer.parseInt(s[s.length - 1]);
    }

    private int getLeftBound(String range) {
        String[] s = range.split("->");
        return Integer.parseInt(s[0]);
    }

    @Test
    public void test() {
        int[] a = new int[] {0,1,2,4,5,7};
        summaryRanges(a);
    }
}
