package com.leetcode.String.easy;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.

 For example, with A = "abcd" and B = "cdabcdab".

 Return 3, because by repeating A three times (��abcdabcdabcd��), B is a substring of it;
 and B is not a substring of A repeated two times ("abcdabcd").

 Note:
 The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    /*
    ���������Ŀ��˼����һ��ʼ��û��˼·�ģ�Ϊʲô����Ϊ����һЩ���Ի���û���ܹ��ڶ�ʱ���ڹ۲����
    ��Ȼ�ʵ�����С�ظ����������и�����Ҫ�������ǣ�
    ����q�Ѿ�ʹ��length(B)<=length(A*q)����ô����A��չΪq+1�������ʱ��B�Ƿ���A*(q+1)���Ӽ��Ѿ��ܹ��жϳ�����
    ��ΪAһֱ�Ǳ��ظ��ģ���B�Ƿ���A*x���Ӽ������ǰ�B��A*x������ĸ��ʼһ��һ���Թ�ȥ������Ѿ���A��ÿ����ĸ��
    �Թ��ˣ���ô����Ͳ���Ҫ�����ˣ���Ϊ�������������ظ�һ��A�ˣ����û���Ӽ������ظ���ȥҲû��������
    ���ֽⷨ���������ҵ�һЩ���ɣ�Ȼ�����úܼ򻯵Ĵ�����ʵ���㷨
     */
    public int repeatedStringMatch(String A, String B) {
        int q = 1;//������ʼ1����0���ؼ����ǿ������ִ���ȥ����ʲô���塣��������for loopû�н���˵��A�Ѿ���B����
        //��ôq��Ȼ��1����Ϊ�����ǿ�A*q��q�����0�Ͳ�����
        StringBuilder sb = new StringBuilder(A);
        for(;sb.length()<B.length();q++) {
            sb.append(A);
        }
        if(sb.indexOf(B)>=0) return q;
        if(sb.append(A).indexOf(B)>=0) return q+1;
        return -1;
    }
}
