package com.leetcode.dynamicprogramming.medium;

/**
 * Alex and Lee continue their games with piles of stones.
 * There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * The game continues until all the stones have been taken.
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 *
 * Example 1:
 *
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 *
 * Constraints:
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
public class StoneGameII {

    public static int stoneGameII(int[] piles) {
        /**
         * 关键是dp的定义，和状态转移方程的确定，这个非常重要
         * TODO: 本题的解法还有待完善，效率比较低下
         */
        int n = piles.length;
        int[] sum = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }

        /**
         * 突然有种感觉，其实根据题目描述来写算法，就是对其先进行数学建模
         * 和stoneGame1是有明显区别的
         * stoneGame1里是从两端其中之一取值，比较自然能想到dp[i][j]定义为piles[i]...piles[j]先手最多能多拿几个stone
         * 最终状态就是dp[0][n - 1]，即从一开始先手比对手多拿几个
         * 而stoneGame2里是从一端按顺序按规则去取值，这个时候的dp定义显然不会是一样的。
         * dp[i][j]依旧往最小子结构去想，这里的定义是最多可以拿多少。
         * 这一步一定要想清楚，最小子结构一定是不可再分割的
         * 这里的j一开始是比较难理解的，因为它不是index，而是用来约束先手拿的X的值，即M。
         */
        for (int i = n - 1; i >= 0; i--) {
            /**
             * 这个状态转移方程需要从这个for循环开始理解
             * 它不是一开始我以为的就两种状态，一种是dp[i][j]本身，另一种是当前所有值的总和减去后手拿的dp
             * 这样理解就会无形中陷入思维的死循环
             * 而应该这样去理解：
             * 每次选择的时候是有策略的，这个策略取决于X，而X又是和M相关
             * （这里不用太在意第一层的M会不会多次循环之后过大，因为内层循环里i + X <= n会控制住使得X不会太大）
             * 总结一下就是sum[i] - dp[i + X][Math.max(M, X)]就是状态转移方程
             */
            for (int M = 1; M <= n; M++) {
                for (int X = 1; X <= 2 * M && i + X <= n; X++) {
                    dp[i][M] = Math.max(dp[i][M], sum[i] - dp[i + X][Math.max(M, X)]);
                }
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(stoneGameII(new int[]{1,2}));
    }
}
