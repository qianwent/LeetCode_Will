package com.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

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
	    	map.put(numbers[i], i);
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
//	        map.put(numbers[i], i);
	    }
	    return result;
	}
	
}
