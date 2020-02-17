package com.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

	public static void main(String[] args) {

		int[] nums = {3,1,2,3};
		boolean b = containsNearbyDuplicate(nums, 2);
		System.out.println(b);
		
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		boolean b = false;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
//			map.put(nums[i], i);//can't be here base on the requirement
			if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<=k) {
				b = true;
			}
			map.put(nums[i], i);
		}
		return b;
	}

}
