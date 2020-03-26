package com.leetcode.dynamicprogramming.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * 这是简单版本，因为只需要求出最大利润，即一遍循环下来，差值最大即可
 */
public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length, min = prices[0];
        int[] profit = new int[n];
        for (int i = 1; i < n; i++) {
            /**
             * 这一步很显然在扫描整个数组的时候把最小值记录记录下来
             * 但光有最小price是不够的，还需要记录另外一个profit
             * 总的逻辑就是：指针向后移动过程中，先保存最小股价，然后当前股价减去最小股价，和前一个指针所保存的利润比较
             * 取更大的那个值，而前一个利润是怎么得来的，也是同样的过程计算而来的
             * 这个就是核心的状态转移公式
             * 看到这里也就很明确边界条件的确定也很重要了，比如min和profit的初始值就是0
             */
            min = Math.min(prices[i], min);
            if (prices[i] > prices[i - 1]) {
                profit[i] = Math.max(prices[i] - min, profit[i - 1]);
            } else {
                profit[i] = profit[i - 1];
            }
        }
        return profit[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
