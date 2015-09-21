package leetcode;

import java.util.ArrayList;

/**
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        for (int i = 2; i < n; i ++) {
            list.add(i, list.get(i -1) + list.get(i - 2));
        }
        return list.get(n - 1);
    }

}
