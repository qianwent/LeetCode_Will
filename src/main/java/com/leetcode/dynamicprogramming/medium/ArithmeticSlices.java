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
     * ������Ŀ���ľ��ǵȲ����е���˼��Ҫ���������������Ҫ��ĵȲ����еĸ���
     * �޶������ǣ��ӵȲ����еĳ���������3����������׵õ�
     * ע�⣺����A�ǲ��ǵȲ����У�û���κ�Ӱ��
     * ��Ϊ���ҵ�һ���ӵȲ�����֮�󣬺����ļ���elementֵ�����ǵȲ����Ӱ��ǰ�����е�dpֵ
     * ֻ�к������������������ĵȲ����У�dpֵ�Ż��������
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

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 7, 8, 9, 10}));
    }
}
