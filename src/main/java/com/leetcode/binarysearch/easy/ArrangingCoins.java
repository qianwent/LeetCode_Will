package com.leetcode.binarysearch.easy;

/**
 * Created by Wentao Qian on 2/22/2018.
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

    //TODO:这个思路实际上是用上了数学运算，还需要深入理解一下
    public int arrangeCoins_bs(int n) {
        int l=0, r=n;
        while(l<=r) {
            int mid = (l+r)/2;
            if(0.5*mid*mid+0.5*mid<=n) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return l-1;
    }

    //这个方法非常直观，似乎使这个问题变成了一个常识，但是我们还是得看下二分查找在这里是怎么用的
    public int arrangeCoins(int n) {
        if(n<1) return 0;
        for(int i=1; ; i++) {
            n -= i;
            if(n<0) return i-1;
        }
    }
}
