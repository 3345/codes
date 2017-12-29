package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 12/28/17.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= nums.length - 4; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] * 4 > target) {
                return list;
            }
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (nums[j] * 3 > target - nums[i]) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }

                    if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }

        return list;
    }

    @Test
    public void test() {
        int[]a = new int[] {1, 0, -1, 0, -2, 2};
        int target = 0;
        fourSum(a, target);
    }
}
