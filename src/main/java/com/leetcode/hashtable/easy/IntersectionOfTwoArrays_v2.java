package com.leetcode.hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 */
public class IntersectionOfTwoArrays_v2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num)>0) {
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for(Integer num: list) {//有的时候这个也会遗忘，说明还不熟练啊。。。
            result[i++] = num;
        }
        return result;
    }

}
