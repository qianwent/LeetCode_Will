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
 ��
 �� ��
 �� ��

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ��
 �� ��
 �� �� ��
 �� ��

 Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

    //TODO:���˼·ʵ��������������ѧ���㣬����Ҫ��������һ��
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

    //��������ǳ�ֱ�ۣ��ƺ�ʹ�����������һ����ʶ���������ǻ��ǵÿ��¶��ֲ�������������ô�õ�
    public int arrangeCoins(int n) {
        if(n<1) return 0;
        for(int i=1; ; i++) {
            n -= i;
            if(n<0) return i-1;
        }
    }
}