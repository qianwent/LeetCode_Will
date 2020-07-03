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
         * �ؼ���dp�Ķ��壬��״̬ת�Ʒ��̵�ȷ��������ǳ���Ҫ
         * TODO: ����Ľⷨ���д����ƣ�Ч�ʱȽϵ���
         */
        int n = piles.length;
        int[] sum = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }

        /**
         * ͻȻ���ָо�����ʵ������Ŀ������д�㷨�����Ƕ����Ƚ�����ѧ��ģ
         * ��stoneGame1�������������
         * stoneGame1���Ǵ���������֮һȡֵ���Ƚ���Ȼ���뵽dp[i][j]����Ϊpiles[i]...piles[j]��������ܶ��ü���stone
         * ����״̬����dp[0][n - 1]������һ��ʼ���ֱȶ��ֶ��ü���
         * ��stoneGame2���Ǵ�һ�˰�˳�򰴹���ȥȡֵ�����ʱ���dp������Ȼ������һ���ġ�
         * dp[i][j]��������С�ӽṹȥ�룬����Ķ������������ö��١�
         * ��һ��һ��Ҫ���������С�ӽṹһ���ǲ����ٷָ��
         * �����jһ��ʼ�ǱȽ������ģ���Ϊ������index����������Լ�������õ�X��ֵ����M��
         */
        for (int i = n - 1; i >= 0; i--) {
            /**
             * ���״̬ת�Ʒ�����Ҫ�����forѭ����ʼ���
             * ������һ��ʼ����Ϊ�ľ�����״̬��һ����dp[i][j]������һ���ǵ�ǰ����ֵ���ܺͼ�ȥ�����õ�dp
             * �������ͻ�����������˼ά����ѭ��
             * ��Ӧ������ȥ��⣺
             * ÿ��ѡ���ʱ�����в��Եģ��������ȡ����X����X���Ǻ�M���
             * �����ﲻ��̫�����һ���M�᲻����ѭ��֮�������Ϊ�ڲ�ѭ����i + X <= n�����סʹ��X����̫��
             * �ܽ�һ�¾���sum[i] - dp[i + X][Math.max(M, X)]����״̬ת�Ʒ���
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
