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
     * Ŀǰ������򵥵�����Ҫ��ѧ֤�����㷨�������ض������£�˭���ֱ�Ӯ
     */
    public boolean divisorGame(int N) {
        if (N % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * ����һ��״̬ת�Ʒ��̣�dp[x] = !dp[N-x] TODO ��������������⻹�����
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
             * ������j < i / 2�����ɺϣ�ʵ��ִ���߼�����̫��
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
             * ������j <= i / 2�����ɺϣ������߼������ǲ�Ҫ�������ñ߽�����dp[2]����ע�͵��Ĳ�����Ȼ�ǲ�����������
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
