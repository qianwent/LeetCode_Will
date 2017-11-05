package com.leetcode.hashtable.easy;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection_two_sets(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    //这是第一个想到的方法，在不了解list和set在查找搜索方面的性能问题的情况下，比较直观的一种解法
    //效果是速度很慢
    //经过多种相似方法测试过后，终于发现无论用两个set还是一个set一个list，效率差不多
    //而影响效率的是最后一步输出新的array
    //如果用Java8先把list或set转成stream，再用mapToInt(i->i).toArray()，则效率比较低下
    //如果只用array，则效率明显提升
    public static int[] intersection(int[] nums1, int[] nums2) {
        long start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
//        Set<Integer> newSet = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }
        for(int num: nums2) {
            if(set.contains(num)) {
                set.remove(num);
//                newSet.add(num);
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            result[i++] = num;
        }
//        int[] result = list.stream().mapToInt(i->i).toArray();
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end-start) + "ms");
        return result;
//        return newSet.stream().mapToInt(i->i).toArray();
    }

    public static void main(String args[]) {
        //测试intersection方法里两种不同return方式的效率
        //结果太明显，用纯array的方法return，方法执行时间在0-16ms
        // 用Java8虽然行数只有一行，但是方法执行时间在45-79ms，效率差很多
        //这是一个不错的比较lambda和传统方法效率的例子
        int[] num1 = new int[10000];
        for(int i=0; i<10000; i++) {
            num1[i] = i;
        }
        int[] num2 = new int[2000];
        for(int i=0; i<2000; i++) {
            num2[i] = 2000-i;
        }
        intersection(num1, num2);
    }

}
