package leetcode;

/**
 * Created by yulai on 12/13/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur ^= nums[i];
        }

        return cur;

    }
}
