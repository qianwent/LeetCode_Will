package com.leetcode.dynamicprogramming.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i �� j), inclusive.
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
         * ������˼άȷʵ��Ҫ�ָ���������һ��ʼȷʵ�뵽��������������ת˲����
         * ʵ����ȷʵ���������Ǻܸ�Ч��
         * ���Ȱ�0-j���ۼӲ�����������Ȼ��(i,j)=(0,j)-(0,i-1)��״̬ת�Ʒ��̾��ֵõ���
         */
        sum = nums;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0 ? nums[0] : nums[i] + sum[i - 1]);
        }
    }

    public int sumRange(int i, int j) {
        /**
         * Ŀǰ��ϰ�����ȳ�����ʽ��Ȼ�󶨱߽�
         */
//        return sum[j] - sum[i - 1];
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
    }
}
