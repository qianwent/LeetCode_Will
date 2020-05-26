package com.leetcode.dynamicprogramming.medium;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 */
public class StoneGame {

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        /**
         * 这是目前看到的最能够帮助理解此类题型的解法
         * https://www.cnblogs.com/qq874455953/p/9901067.html
         * 用DP来求解，着实花了点时间来全面理解本题中最小子结构，以及状态转移方程的确定
         */
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        /**
         * 这里两层for循环，就是从最小子结构开始，即2个小堆的dp最优解，算到n个小堆
         * 如何分析：首先很明确的是先手一定从两端选，选完之后就是n-1个piles
         * dp[i,j]定义为piles[i]...piles[j]先手最多能多拿几个stone，这个定义非常重要
         * 然后开始状态转移方程，如果选手A拿了piles[i]，则选手B比A最多能多拿dp[i+1][j]
         * 继而A在拿piles[i]时，最多能比B多拿的就是dp[i][j]=piles[i]-dp[i+1][j]
         * 此时一部分状态转移方程就出来了，另一部分就是当A拿了piles[j]，相应的dp[i][j]=piles[j]-dp[i][j-1]
         * 两者取最大值，即为最终dp[i][j]
         * 一开始对二维数组在这里的作用理解有偏差，不要认为二维数组的所有元素都要用到
         * 在本题中只是起到标注范围的作用
         */
        for (int dis = 1; dis < n; dis++) {
            for (int i = 0; i < n - dis; i++) {
                dp[i][i + dis] = Math.max(piles[i] - dp[i + 1][i + dis], piles[i + dis] - dp[i][i + dis - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
    }
}
