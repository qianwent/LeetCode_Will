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
         1.ArrayList��ʵ���˻��ڶ�̬��������ݽṹ��LinkedList������������ݽṹ��
         2.�����������get��set��ArrayList��������LinkedList����ΪLinkedListҪ�ƶ�ָ�롣 
         3.����������ɾ������add��remove��LinedList�Ƚ�ռ���ƣ���ΪArrayListҪ�ƶ����ݡ�
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
        // listת����array���������Ҫ��Ϥ����ǰ�õò���
        return res.toArray(new String[res.size()]);
    }

}
