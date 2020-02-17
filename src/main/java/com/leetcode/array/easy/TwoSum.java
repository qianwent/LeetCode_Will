package com.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {2,7,11,15};
		int target = 9;
		int result[] = TwoSum.twoSum(numbers, target);
		for(int r : result) {
			System.out.println(r);
		}
		
	}

	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
//	    	map.put(numbers[i], i);//can't put here, this is causing error
	    	/*
	    	 * for example:
	    	 * [3,2,4]
	    	 * 6
	    	 * if map.put logic is at first, then 3 and index 0 will be put into map, and same element is used twice
	    	 * which is contradictory with the requirement
	    	 */
	    	// 根据值来确定index，那么自然而然就会把array的value作为key， 把array的index作为value存入map中
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
	
}
