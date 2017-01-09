package leetcode;

import java.util.*;

/**
 * Created by fuyul on 1/9/2017.
 */
public class RandomPickIndex {
    public class Solution {
        Map<Integer, Integer> occ = new HashMap<>();
        int[] nums = null;
        public Solution(int[] nums) {
            if (nums == null) {
                return;
            }
            this.nums = nums;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    if (occ.containsKey(nums[i])) {
                        occ.put(nums[i], occ.get(nums[i]) + 1);
                    } else {
                        occ.put(nums[i], 2);
                    }
                } else {
                    set.add(nums[i]);
                }
            }
        }

        public int pick(int target) {
            if (!occ.containsKey(target)) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
            } else {
                int rand = new Random().nextInt(occ.get(target));
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == target) {
                        if (rand == 0) {
                            return i;
                        } else {
                            rand--;
                        }
                    }
                }
            }

            return -1;
        }
    }

}
