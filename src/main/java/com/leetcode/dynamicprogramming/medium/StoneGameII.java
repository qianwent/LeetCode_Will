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
         * TODO，这种思路目前不是太理解
         */
        int n = piles.length;
        int[] sum = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 2 * j && i + k <= n; k++) {
                    dp[i][j] = Math.max(dp[i][j], sum[i] - dp[i + k][Math.max(j, k)]);
                }
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
    }
}
