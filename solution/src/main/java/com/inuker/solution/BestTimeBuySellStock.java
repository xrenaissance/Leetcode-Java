package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * https://leetcode.com/articles/best-time-buy-and-sell-stock/
 */
public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0], maxProfit = 0;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(min, price);
        }

        return maxProfit;
    }
}
