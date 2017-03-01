package com.leetcode.array;

public class MaximumSubarray {

	public static void main(String[] args) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};//{-2}
		int max = maxSubArray(nums);
		System.out.println(max);
		
	}

	public static int maxSubArray(int[] nums) {

//		int max = 0, sum = 0;//如果max设为0，那么如{-1}这样的就错了，要保证max得到是真实的最大值，那就不能设定0这个下限，毫无根据
		int max = Integer.MIN_VALUE, sum = 0;//所以要把max初始值设为int的最小值
		
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
