package leetcode;

/**
 * Created by fyl on 12/13/16.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }
}
