package com.leetcode.dynamicprogramming.easy;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 *
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */
public class DivisorGame {

    /**
     * 目前看到最简单但是需要数学证明的算法，即在特定条件下，谁先手必赢
     */
    public boolean divisorGame(int N) {
        if (N % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 看到一个状态转移方程：dp[x] = !dp[N-x] TODO 对于这种类型理解还不深刻
     */
    public static boolean divisorGame_v2(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        boolean[] dp = new boolean[N + 1];
        for (int i = 3; i <= N; i++) {
            /**
             * 条件用j < i / 2属于巧合，实际执行逻辑并不太对
             */
            for (int j = 1; j < i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = !dp[i - j] || dp[i];
                }
            }
        }
        return dp[N];
    }

    public static boolean divisorGame_v2_1(int N) {
        if (N == 1) {
            return false;
        }
        boolean[] dp = new boolean[N + 1];
//        if (N == 2) {
//            return dp[N] = true;
//        }
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            /**
             * 条件用j <= i / 2属于巧合，符合逻辑，但是不要忘了设置边界条件dp[2]，而注释掉的部分显然是不满足条件的
             */
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = !dp[i - j] || dp[i];
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame_v2(3));
        System.out.println(divisorGame_v2_1(3));
    }
}
