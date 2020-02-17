package com.leetcode.hashtable.easy;

import java.util.*;

import static java.lang.Math.min;


/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.

 Example 1:
 Input: candies = [1,1,2,2,3,3]
 Output: 3
 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.
 Example 2:
 Input: candies = [1,1,2,3]
 Output: 2
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        //һ��ʼ��Ϊ�ǵ�����������������map�������ŷ����в�ͨ������Ǿ��鰡�����Ҫ�õ�unique��kind����ȻҪ�õ�set��
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<candies.length; i++) {
//            if(map.containsKey(candies[i])) {
//                map.put(candies[i], map.get(candies[i])+1);
//            } else {
//                map.put(candies[i], 1);
//            }
//        }

        //��������ľ��Ǽ򵥵�Сѧ��ѧ�⡣����
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<candies.length; i++) {
            set.add(candies[i]);
        }
        return min(set.size(), candies.length/2);

    }

    public int distributeCandies2(int[] candies) {
        //�ڶ��ַ�����������Զ�ѵ��һ�£����Ÿ�����һ��һ��������������count��Ҫ����������2��if�Ե������߼�����
        Arrays.sort(candies);
        int count = 1;
        for(int i=1; i<candies.length; i++) {
            if(count>=candies.length/2) break;
            if(candies[i] != candies[i-1]) {
                count ++;
            }
        }
        return count;
    }

}
