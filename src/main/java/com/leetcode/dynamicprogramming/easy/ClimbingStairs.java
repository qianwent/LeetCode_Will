package com.leetcode.dynamicprogramming.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {

        /**
         * 这个已经看到过多次，状态转移公式比较显然，f(n)=f(n-1)+f(n-2)
         */
        if (n == 1) {
            return 1;
        }
        int w[] = new int[n];
        w[0] = 1; w[1]=2;
        for (int i = 2; i < n; i++) {
            w[i] = w[i - 1] + w[i - 2];
        }
        return w[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
