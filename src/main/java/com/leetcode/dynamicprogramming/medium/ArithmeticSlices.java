package com.leetcode.dynamicprogramming.medium;

/**
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 *
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of the array A is called arithmetic if the sequence:
 * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {

    /**
     * 这类题目表达的就是等差数列的意思，要求的是数列中满足要求的等差数列的个数
     * 限定条件是：子等差数列的长度至少是3，这个很容易得到
     * 注意：数列A是不是等差数列，没有任何影响
     * 因为当找到一个子等差数列之后，后续的几个element值不再是等差，并不影响前面已有的dp值
     * 只有后续继续有满足条件的等差数列，dp值才会继续增加
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int dp[] = new int[A.length + 1];
        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }

    /**
     * 用高斯公式的解法，看起来反而还麻烦一些，因为涉及的条件判断比DP算法要更多一些
     * 但是这个算法的思路看起来更清醒
     * 即先一旦出现符合条件的子等差数列，就把这个数列的长度记录下来，以备后续代入高斯公式进行计算
     * 一旦这个子等差数列断了，那么首先要把已有的等差数列个数算出来，然后重置子等差数列长度为2
     * 根据条件，等差数列长度必须至少为3，加上这个算法里len是累加的，所以这个len=2刚好能满足要求
     */
    public static int numberOfArithmeticSlices_Gauss_Formula(int[] A) {
        int len = 2, count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
            } else {
                if (len > 2) {
                    count += (len - 1) * (len - 2) / 2;
                }
                len = 2;// this step is to reset the temp len value, which is necessary
            }
        }
        if (len > 2) {
            count += (len - 1) * (len - 2) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 7, 8, 9, 10}));
        System.out.println(numberOfArithmeticSlices_Gauss_Formula(new int[]{1, 2, 3, 4, 7, 8, 9, 10}));
        System.out.println(numberOfArithmeticSlices_Gauss_Formula(new int[]{1, 2, 3, 4}));
    }
}
