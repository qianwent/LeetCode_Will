package com.leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.


 */
public class ContainsDuplicate {

    //一开始可能能想到set，但是不知道set.add能返回true / false
    //一旦知道，此题将会变得异常简单
    public boolean containsDuplicate_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    //用map，虽然很多场景都能用，但是较为繁琐
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            //map.getOrDefault(nums[i], 0)这个方法需要指定default value
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        for(Integer i: map.values()) {
            if(i>1) return true;
        }
        return false;
    }
}
