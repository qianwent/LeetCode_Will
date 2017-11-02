package com.leetcode.hashtable.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        //这个算法的精妙之处在于充分利用了map的特性， 包括map.getOrDefault(num, 0)+1， map.containsKey(key+1)
        //这些都是map数据结构的基础与核心
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key: map.keySet()) {
            if(map.containsKey(key+1)) {
                res = Math.max(res, map.get(key)+map.get(key+1));
            }
        }
        return res;
    }

    public static int findLHS_single_loop(int[] nums) {
        //single loop,核心思想和第一种方法是相同的
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.containsKey(num+1)) {
                res = Math.max(res, map.get(num)+map.get(num+1));
            }
            if(map.containsKey(num-1)) {
                res = Math.max(res, map.get(num)+map.get(num-1));
            }
        }
        return res;
    }

    public static int findLHS2(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        int pcount = 0;
        map.put(nums[0],1);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                //仔细想想，这样的思路，坑越挖越多，必须摈弃
                //而且发现这样排序之后，并没有有效地利用map
                //能够看到if else多了之后，逻辑会越来越混乱，很难完美覆盖所有情况，平时项目中也是如此，需留意
                map.put(nums[i], map.get(nums[i-1])+1);
                if(pcount!=0) {
                    pcount++;
                } else {
                    count ++;
                }
                count = Math.max(count, pcount);
            } else if(nums[i]-nums[i-1] == 1){
                map.put(nums[i], 1);
                count = Math.max(count, map.get(nums[i-1])+1);
                pcount = map.get(nums[i-1])+1;
            } else {
                map.put(nums[i], 1);
                if(count==1) count=0;
                count = Math.max(count,0);
            }
        }
        if(map.size()==1) count = 0;
        return count;
    }

    public static void main(String args[]) {
//        int nums[] = {1,3,5,7,9};
//        int nums[] = {1,3,2,2,5,2,3,7};
//        int nums[] = {1,2,1,3,0,0,2,2,1,3,3};
        int nums[] = {1,4,1,3,1,-14,1,-13};
        int count = findLHS(nums);
        System.out.println(count);
    }

}
