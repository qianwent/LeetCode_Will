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
     * ���DP�ⷨ�Ƚ��������
     * DP���ﶨ��Ϊǰiֻ��Ʊ���������
     * ��������Ƶ�Ӧ�������������dp[i]Ҫô�ǵ���dp[i-1]�������ڹ���״̬������Ҳ����
     * Ҫô��������price[i]��ͬʱ���м�ȥi֮ǰ��i-1ʱ����С����m���ټ�ȥfee
     * ��������������m�Ĺ�ʽ��ģ�Ҫ��m��С�����ͱ���Ҫ�����������
     * ��m��ʽ�Ǵ˽ⷨ�Ĺؼ�
     * ��dp���뵽prices[i] - m - fee��Ҫ���з�������
     * 1.prices[i-1]�������룬��ô��С��������prices[i-1]-dp[i-2]
     * 2.prices[i-1]���ܲ����룬������i-1֮ǰ���룬�������������������ܲ�ֹһ�Σ����ǲ�Ӱ���Ƶ�
     * �������£���Ȼprices[i-1]�����룬��m����
     * �������ȥ��Сֵ
     * ��ʼmҲ���ѵõ�������prices[0]�������0�Ļ�����prices[0]������ζ����ᱻ�õ��ˣ���Ϊloop�Ǵ�i=1��ʼ��
     */
    public static int maxProfit_dp(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        int m = prices[0];
        for (int i = 1; i < prices.length; i++) {
            /**
             * ��������ʽ��������Ϣ���Ǻܴ�ģ���������������һ�ۿ���������������ϸ��������������
             */
            dp[i] = Math.max(dp[i - 1], prices[i] - m - fee);
            m = Math.min(m, prices[i] - dp[i - 1]);
        }
        return dp[prices.length - 1];
    }

    public static int maxProfit(int[] prices, int fee) {
        int hold[] = new int[prices.length];
//        hold[0] = Integer.MIN_VALUE;// ������Բ�����
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
