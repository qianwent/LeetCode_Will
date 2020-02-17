package com.leetcode.hashtable.easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Wentao on 8/20/2017.
 */
public class MinimunIndexSumOfTwoLists {

    public static void main(String args[]) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] output = findRestaurant(list1, list2);
        Stream.of(output).forEach(System.out::print);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        /*
         1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
         2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。 
         3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
         */
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i=0;i<list1.length;i++) map.put(list1[i], i);
        for (int i=0;i<list2.length;i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) { res = new ArrayList<>(); minSum = i+j; }
                res.add(list2[i]);
            }
        }
        // list转换成array，这个方法要熟悉，以前用得不多
        return res.toArray(new String[res.size()]);
    }

}
