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
     * TODO matrix相关的到底是什么规律，是否都是和图像处理相关？
     * 先初步理解二维数组的DP其中一种解，目前看来这一种不难理解
     * 和一维的其实是相通的，显然需要另一个数组来保存状态
     * 状态转移方程稍有不同，不像有些一维的那么直接，最终还是找到规律
     * 直观描述就是：每check到一个element的时候，除了看它本身是否为1
     * 还要check跟它形成闭环的i-1 j-1的另外3个元素，组成的方块是否都是1
     * 如果都是1，则dp[i][j]数值显然要大于1
     * 以下这个算法，用的是dp[i][j] = min + matrix[i - 1][j - 1]
     * min就是看周围那3个元素最小是几，如果全是1，说明可以形成闭环，只要有一个0，那就不能闭环
     * 类推到全是2，也是这个意思，dp[i][j]=3，这就是DP开始状态叠加了，并把叠加后的数保存起来
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
