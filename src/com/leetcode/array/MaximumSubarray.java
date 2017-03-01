package com.leetcode.array;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};//{-2}
		int max = maxSubArray(nums);
		System.out.println(max);
		
	}

	public static int maxSubArray(int[] nums) {

//		int max = 0, sum = 0;//���max��Ϊ0����ô��{-1}�����ľʹ��ˣ�Ҫ��֤max�õ�����ʵ�����ֵ���ǾͲ����趨0������ޣ����޸���
		int max = Integer.MIN_VALUE, sum = 0;//����Ҫ��max��ʼֵ��Ϊint����Сֵ
		
		for(int i=0; i<nums.length; i++) {
			if(sum<0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
		
	}

}
