package com.leetcode.dynamicprogramming.easy;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        /**
         * easyģʽ�µ�DP���ǱȽ����׿���״̬ת�ƹ�ʽ
         * f(n)=Math.max(f(n-1), f(n-2)+nums[n])
         */
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int rob[] = new int[N];
        rob[0] = nums[0];
        if (N == 1) {
            return rob[0];
        }
        rob[1] = Math.max(nums[1], rob[0]);
        if (N == 2) {
            return rob[1];
        }
        for (int i = 2; i < N; i++) {
            rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
        }
        return rob[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
