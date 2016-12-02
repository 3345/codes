package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 12/1/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        if (nums == null) {
            return ret;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int n = nums[i];

            if (!visited.contains(n)) {
                visited.add(n);

                int target = 0 - n;

                int p1 = i + 1;
                int p2 = nums.length - 1;

                while (p1 < p2) {
                    if (p1 == i) {
                        p1 ++;
                        continue;
                    }

                    if (p2 == i) {
                        p2 --;
                        continue;
                    }

                    if (nums[p1] + nums[p2] == target) {
                        if (!ret.isEmpty() && ret.get(ret.size() - 1).get(0) == n) {
                            int lastN = ret.get(ret.size()-1).get(1);
                            if (lastN != nums[p1] && lastN != nums[p2]) {
                                ret.add(Arrays.asList(n, nums[p1], nums[p2]));
                            }
                        } else {
                            ret.add(Arrays.asList(n, nums[p1], nums[p2]));

                        }
                        p1 ++;
                        p2 --;
                    } else if (nums[p1] + nums[p2] < target) {
                        p1 ++;

                    } else {
                        p2 --;
                    }
                }
            }
        }

        return ret;
    }

    @Test
    public void t() {
        int[] input = new int[] {3,0,-2,-1,1,2};
        List<List<Integer>> ans = threeSum(input);
        System.out.println(new Gson().toJson(ans));
    }
}
