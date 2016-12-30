package leetcode;

/**
 * Created by yulai on 12/27/16.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return new int[]{};
        }

        int[] left = new int[nums.length];
        left[0] = 1;

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;

        //1,2,3,4
        //1,1,2,6
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        //1,2,3,4
        //24,12,4,1
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
