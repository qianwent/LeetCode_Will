package com.leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process:
 Starting with any positive integer, replace the number by the sum of the squares of its digits,
 and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2+ 0^2 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
//        int temp=0, individual;
        int temp, individual;
        while (set.add(n)) {
            temp = 0;//temp必须在每次大循环的时候归零，否则temp也就没有意义了
            while (n>0) {
                individual = n%10;
                temp += individual*individual;
                n /= 10;//这个特性居然忘了，除以10得到的是一个整数。。。
            }
            if(temp == 1) {
                return true;
            } else {
                n = temp;//这又是关键一步，否则怎么继续往下算呢。。。
            }
        }
        return false;
    }

    public boolean isHappy_wrong_logic(int n) {
        Set<Integer> set = new HashSet<>();
        int temp=0, individual;
        while (set.add(n)) {
            while (n>0) {
//                if(n%10!=0) {
                    individual = n%10;
                    temp += individual*individual;
                    n -= n%10;
//                } else {
//                    temp += n*n/100;
//                }
            }
        }
        return false;
    }

    public boolean isHappy_v0(int n) {
        Set<Integer> set = new HashSet<>();
        //根据答案提示，得到的思路，为了应对无限循环，即后续的加和得到的数在之前已经出现过，
        //那么这种情况就要返回false了
        while (set.add(n)) {
            //...
        }
        return false;
    }

}
