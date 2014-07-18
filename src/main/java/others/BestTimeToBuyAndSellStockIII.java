package others;

import org.junit.Test;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        int[] a1 = new int[prices.length];
        int[] a2 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
            a1[i] = profit;
        }
        profit = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >=0; i --) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
            a2[i] = profit;
        }

        profit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, a1[i] + a2[i]);
        }

        return profit;

    }

    @Test
    public void test() {
        int[] a = {1,2};
        maxProfit(a);
    }
}
