package com.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,1,2,4,5};
		int m = missingNumber(nums);
		System.out.println(m);
		
		int mm = missingNum(nums);
		System.out.println(mm);
		
		int[] nums2 = {1,2,5,7,9};
		List<Integer> list = missingNumbers(nums2);
		System.out.println(list);
		
		int[] nums_ = {1,3,4,5,0};
		int mm_ = missingNumberG(nums_);
		System.out.println(mm_);
		
	}

	//general solution
	public static int missingNumberG(int[] nums) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		//这里有卡顿，实际上是因为题目没有说明如[0,1,2]是不完整的，而按照答案的意思，就是缺3...无所谓啦，按照他们的意思来吧
		return nums.length*(nums.length+1)/2 - sum;
	}
	
	//这个算法只能针对缺少一个数字的array
	public static int missingNumber(int[] nums) {

	    int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}
	
	//这种算法只能对排序好的array有效，打乱顺序就不对了
	public static int missingNum(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=i) return i;
		}
		return nums.length;
	}
	
	//如果miss的不止一个数，那以下是个人的思路，真心复杂，也就自己看得懂了。。。
	public static List<Integer> missingNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			if(i==0 && nums[i]!=0) {
				list.add(0);
				continue;
			}
			if((nums[i]-nums[i-1])!=1) {
				for(int j=0; j<(nums[i]-nums[i-1])-1; j++) {
					list.add(nums[i-1]+1+j);
				}
			}
		}
		return list;
	}
	
}
