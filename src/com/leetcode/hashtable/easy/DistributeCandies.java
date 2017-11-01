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
        //一开始以为是单纯的数数，就用了map，后来才发现行不通，这就是经验啊，如果要得到unique的kind，显然要用到set了
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<candies.length; i++) {
//            if(map.containsKey(candies[i])) {
//                map.put(candies[i], map.get(candies[i])+1);
//            } else {
//                map.put(candies[i], 1);
//            }
//        }

        //看看，真的就是简单的小学数学题。。。
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<candies.length; i++) {
            set.add(candies[i]);
        }
        return min(set.size(), candies.length/2);

    }

    public int distributeCandies2(int[] candies) {
        //第二种方法，这个可以多训练一下，先排个序，再一个一个数过来，不过count需要搞清楚，如果2个if对调，则逻辑错误
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
