package com.leetcode.binarysearch.easy;

/**
 * Created by Wentao Qian on 1/8/2018.
 * Implement int sqrt(int x).
 Compute and return the square root of x. x is guaranteed to be a non-negative integer.

 Example 1:
 Input: 4
 Output: 2

 Example 2:
 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842...,
 and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrt_X {

    public int mySqrt(int x) {

        int left = 1, right = x;

        while(left<right) {
            int mid = left + (right - left)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)) {
                //found solution
                //ע��mid<=x/mid��������һ����������>=��̫��Ȼ�˰�����+1�ˣ���Ȼ>���������endless loop
                return mid;
            } else if(mid>x/mid) {
                right = mid;
            } else {
                left = mid+1;//����+1���������ڼ��ٲ���Ҫ������
                //����Ϳ���һ���߼���
                //��Ϊ�ܽ��뵽else���棬˵��else if statement�ǲ�����ģ��̶�˵��mid<=x/mid�������
                //�������˵��ֻ���ڲ�����(mid+1)>x/(mid+1)������£��Ż��������else�ж�
                //���ˣ��ͱȽ����׿���left����Ҫ���mid+1��������ǰ��Ѿ���С�ķ�Χ�ٴ�������
                //һ��Ҫע�⣬�����ö��ַ������ǰѷ�Χһ��һ����С�����(mid+1)*(mid+1) <= x������ָ��ͱ�����mid+1
                //������㷨�Ż���һЩϸ�ڣ���Ϊ�������left=mid��Ҳ�ܵõ�������������ʾ��½���
            }
        }
        return left;

    }

}
