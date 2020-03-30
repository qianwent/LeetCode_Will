package com.leetcode.dynamicprogramming.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        /**
         * 开阔的思维确实需要恢复起来啊，一开始确实想到过做减法，但是转瞬即逝
         * 实际上确实是做减法是很高效的
         * 即先把0-j的累加并保存起来，然后(i,j)=(0,j)-(0,i-1)，状态转移方程就又得到了
         */
        sum = nums;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0 ? nums[0] : nums[i] + sum[i - 1]);
        }
    }

    public int sumRange(int i, int j) {
        /**
         * 目前是习惯于先出方程式，然后定边界
         */
//        return sum[j] - sum[i - 1];
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
    }
}
