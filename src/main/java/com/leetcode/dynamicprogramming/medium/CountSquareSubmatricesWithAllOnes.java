package com.leetcode.dynamicprogramming.medium;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 * <p>
 * Input: matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class CountSquareSubmatricesWithAllOnes {

    /**
     * TODO matrix��صĵ�����ʲô���ɣ��Ƿ��Ǻ�ͼ������أ�
     * �ȳ�������ά�����DP����һ�ֽ⣬Ŀǰ������һ�ֲ������
     * ��һά����ʵ����ͨ�ģ���Ȼ��Ҫ��һ������������״̬
     * ״̬ת�Ʒ������в�ͬ��������Щһά����ôֱ�ӣ����ջ����ҵ�����
     * ֱ���������ǣ�ÿcheck��һ��element��ʱ�򣬳��˿��������Ƿ�Ϊ1
     * ��Ҫcheck�����γɱջ���i-1 j-1������3��Ԫ�أ���ɵķ����Ƿ���1
     * �������1����dp[i][j]��ֵ��ȻҪ����1
     * ��������㷨���õ���dp[i][j] = min + matrix[i - 1][j - 1]
     * min���ǿ���Χ��3��Ԫ����С�Ǽ������ȫ��1��˵�������γɱջ���ֻҪ��һ��0���ǾͲ��ܱջ�
     * ���Ƶ�ȫ��2��Ҳ�������˼��dp[i][j]=3�������DP��ʼ״̬�����ˣ����ѵ��Ӻ������������
     */
    public static int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        int count = 0;

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int min = findMin(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = min + matrix[i - 1][j - 1];
                    if (dp[i][j] > 1) {
                        count = count + dp[i][j];
                    } else {
                        count = count + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return count;
    }

    private static int findMin(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(countSquares(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }
}
