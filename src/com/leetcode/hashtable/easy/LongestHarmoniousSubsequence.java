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
        //����㷨�ľ���֮�����ڳ��������map�����ԣ� ����map.getOrDefault(num, 0)+1�� map.containsKey(key+1)
        //��Щ����map���ݽṹ�Ļ��������
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
        //single loop,����˼��͵�һ�ַ�������ͬ��
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
                //��ϸ���룬������˼·����Խ��Խ�࣬�������
                //���ҷ�����������֮�󣬲�û����Ч������map
                //�ܹ�����if else����֮���߼���Խ��Խ���ң����������������������ƽʱ��Ŀ��Ҳ����ˣ�������
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
