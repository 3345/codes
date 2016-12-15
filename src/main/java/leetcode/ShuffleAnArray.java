package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Random;

/**
 * Created by fyl on 12/15/16.
 */
public class ShuffleAnArray {
    public class Solution {
        int[] original = null;

        public Solution(int[] nums) {
            this.original = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                original[i] = nums[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if (original.length < 2) {
                return original;
            }
            int[] a = new int[original.length];
            for (int i = 0; i < original.length; i ++) {
                a[i] = original[i];
            }

            for (int i = 0; i < a.length; i++) {
                Random random = new Random();
                int index = random.nextInt(a.length - i) + i;
                int tmp = a[i];
                a[i] = a[index];
                a[index] = tmp;
            }

            return a;
        }
    }

    @Test
    public void t() {
        int[] input = new int[] {1,2,3,4};
        Solution solution = new Solution(input);
        System.out.println(new Gson().toJson(solution.shuffle()));
        System.out.println(new Gson().toJson(solution.shuffle()));
        System.out.println(new Gson().toJson(solution.shuffle()));
        System.out.println(new Gson().toJson(solution.shuffle()));
        System.out.println(new Gson().toJson(solution.shuffle()));
    }
}
