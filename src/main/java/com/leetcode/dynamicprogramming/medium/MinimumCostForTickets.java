package com.leetcode.dynamicprogramming.medium;

/**
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2,
 * then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * Note:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class MinimumCostForTickets {

    /**
     * 最小子结构的定义还是不敏感，一开始在dp[i][j]卡了很久，其实dp[i]就足够了
     * 对于dp的定义也很重要，准确来说是dp[days[i]]
     * 因为days array不是连续的，直接用dp[i]的后果就是，没在days里的天数没法表示了
     * 用dp[days[i]]的话，就变成连续了，这相当于在建模的时候对模型的补完，显然是一种常规技巧
     * 既然填充成连续的数组了，那么自然对于days[i]去与不去，就需要标记好，因为某一天不去的话，dp[i]==dp[i-1]
     * 剩下的逻辑比较好处理了，简单的分段函数
     * 1.dp[i-1]+costs[0]
     * 2.if (i-7>0) dp[i-7]+costs[1] else dp[0]+costs[1]
     * 3.if (i-30>0) dp[i-30]+costs[2] else dp[0]+costs[2]
     */
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        boolean[] b = new boolean[days[n - 1] + 1];
        for (int i = 0; i < n; i++) {
            b[days[i]] = true;
        }
        for (int i = 1; i <= days[n - 1]; i++) {
            if (b[i]) {
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[days[n - 1]];
    }

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(mincostTickets(new int[]{1}, new int[]{2, 7, 15}));
    }
}
