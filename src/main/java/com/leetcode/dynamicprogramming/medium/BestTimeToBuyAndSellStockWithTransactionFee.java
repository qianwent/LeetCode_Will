package com.leetcode.dynamicprogramming.medium;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 这个DP解法比较难以理解
     * DP这里定义为前i只股票的最大收益
     * 最基本的推导应该是两种情况，dp[i]要么是等于dp[i-1]，即处于观望状态，不买也不卖
     * 要么是卖出，price[i]，同时还有减去i之前即i-1时的最小付出m，再减去fee
     * 而买入是体现在m的公式里的，要让m最小化，就必须要考虑如何买入
     * 而m公式是此解法的关键
     * 当dp进入到prices[i] - m - fee，要进行分类讨论
     * 1.prices[i-1]可能买入，那么最小付出就是prices[i-1]-dp[i-2]
     * 2.prices[i-1]可能不买入，而是在i-1之前买入，并且买入卖出操作可能不止一次，但是不影响推导
     * 这个情况下，既然prices[i-1]不买入，则m不变
     * 两种情况去最小值
     * 初始m也不难得到，得是prices[0]，如果是0的话，那prices[0]无论如何都不会被用到了，因为loop是从i=1开始的
     */
    public static int maxProfit_dp(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        int m = prices[0];
        for (int i = 1; i < prices.length; i++) {
            /**
             * 这两个公式包含的信息量是很大的，比如买入卖出，一眼看不出来，但是仔细分析，是有这层的
             */
            dp[i] = Math.max(dp[i - 1], prices[i] - m - fee);
            m = Math.min(m, prices[i] - dp[i - 1]);
        }
        return dp[prices.length - 1];
    }

    public static int maxProfit(int[] prices, int fee) {
        int hold[] = new int[prices.length];
//        hold[0] = Integer.MIN_VALUE;// 这个明显不合理
        hold[0] = -prices[0];
        int sold[] = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return sold[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit_dp(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit_dp(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
