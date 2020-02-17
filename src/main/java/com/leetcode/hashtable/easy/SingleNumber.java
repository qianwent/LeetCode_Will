package com.leetcode.hashtable.easy;

/*
 * bitwise operators are useful in some special case
 * like XOR ^
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,1,2,2,3,3,4,4,5,6,6,7,7};
		
		int singleNum = singleNumber(nums);
		
		System.out.println(singleNum);
		
	}

	public static int singleNumber(int[] nums) {

		int ans = 0;
		
		int len = nums.length;
		
		for(int i=0; i<len; i++) 
			ans ^= nums[i];
		
		return ans;
		
	}

}
