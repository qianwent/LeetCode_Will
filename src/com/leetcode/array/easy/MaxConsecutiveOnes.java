package com.leetcode.array.easy;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		int[] nums = {1,1,0,0,1,1,1};
		int num = findMaxConsecutiveOnes(nums);
		System.out.println(num);
		
	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		int count=0;
		int num = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==1) {
				count++;
				num = count>num? count : num;
			} else {
				count = 0;
//				num = 0;//如果有这个逻辑的话，那每次数完相当于丢失了，显然错误
			}
		}
		return num;
		
	}

}
