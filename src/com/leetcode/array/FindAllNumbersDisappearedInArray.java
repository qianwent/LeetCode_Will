package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

	public static void main(String[] args) {

		int[] nums = new int[10];
//		nums[0] = 4;
//		nums[1] = 3;
//		nums[2] = 2;
//		nums[3] = 7;
//		nums[4] = 8;
//		nums[5] = 2;
//		nums[6] = 3;
//		nums[7] = 1;
		nums[0] = 3;
		nums[1] = 2;
		nums[2] = 1;
		nums[3] = 5;
		nums[4] = 2;//7在本题中是无效的，注意条件1 ≤ a[i] ≤ n (n = size of array)
		
		List<Integer> list = findDisappearedNumbers(nums);
		System.out.println(list);
		
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			int abVal = Math.abs(nums[i])-1;
			if(nums[i]==0) continue;
			if(nums[abVal] > 0)
			nums[abVal] = -nums[abVal];
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i]>0) list.add(i+1);
		}
		return list;
	}

}
