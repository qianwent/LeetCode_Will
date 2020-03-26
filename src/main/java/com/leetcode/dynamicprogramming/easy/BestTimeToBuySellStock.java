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
 * ���Ǽ򵥰汾����Ϊֻ��Ҫ���������󣬼�һ��ѭ����������ֵ��󼴿�
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
             * ��һ������Ȼ��ɨ�����������ʱ�����Сֵ��¼��¼����
             * ��������Сprice�ǲ����ģ�����Ҫ��¼����һ��profit
             * �ܵ��߼����ǣ�ָ������ƶ������У��ȱ�����С�ɼۣ�Ȼ��ǰ�ɼۼ�ȥ��С�ɼۣ���ǰһ��ָ�������������Ƚ�
             * ȡ������Ǹ�ֵ����ǰһ����������ô�����ģ�Ҳ��ͬ���Ĺ��̼��������
             * ������Ǻ��ĵ�״̬ת�ƹ�ʽ
             * ��������Ҳ�ͺ���ȷ�߽�������ȷ��Ҳ����Ҫ�ˣ�����min��profit�ĳ�ʼֵ����0
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
