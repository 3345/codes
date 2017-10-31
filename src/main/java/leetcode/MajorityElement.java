package leetcode;

import java.util.Arrays;

/**
 * Created by fyl on 10/23/17.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
    }
}
