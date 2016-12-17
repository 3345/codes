package leetcode;

/**
 The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color red;
 costs[1][2] is the cost of painting house 1 with color green, and so on
 ... Find the minimum cost to paint all houses.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int numOfHouse = costs.length;

        int[][] dp = new int[numOfHouse][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < numOfHouse; i ++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        int min = Math.min(dp[numOfHouse - 1][0], dp[numOfHouse - 1][1]);
        min = Math.min(min, dp[numOfHouse - 1][2]);
        return min;
    }
}
