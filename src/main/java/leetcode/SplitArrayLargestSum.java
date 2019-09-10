package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayLargestSum {
    long ans = 0;
    int m;
    int[] nums;

    public int splitArray(int[] nums, int m) {
        this.m = m;
        this.nums = nums;
        int max = 0;
        long sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        if (m == 1) return (int)sum;
        bs(max, sum);
        return (int)ans;
    }

    private void bs(long left, long right) {
        if (left >= right) {
            ans = left;
            return;
        }
        long mid = (left+right)/2;
        long count = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                sum = nums[i];
                count++;
            }
        }

        if (count > m) {
            bs(mid+1, right);
        } else {
            bs(left,mid-1);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5};
        int m = 2;
        splitArray(nums, m);
    }
}
