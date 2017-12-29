package leetcode;

/**
 * Created by fyl on 12/28/17.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                end --;
            } else {
                start++;
            }
        }
        return nums[start] == val ? start : start + 1;
    }
}
