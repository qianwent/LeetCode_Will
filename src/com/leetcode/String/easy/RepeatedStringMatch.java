package com.leetcode.String.easy;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.

 For example, with A = "abcd" and B = "cdabcdab".

 Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it;
 and B is not a substring of A repeated two times ("abcdabcd").

 Note:
 The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    /*
    对于这个题目的思考，一开始是没有思路的，为什么？因为对于一些特性还是没有能够在短时间内观察出来
    虽然问的是最小重复数，但是有个很重要的特性是：
    假设q已经使得length(B)<=length(A*q)，那么当把A拓展为q+1，则这个时候B是否是A*(q+1)的子集已经能够判断出来了
    因为A一直是被重复的，看B是否是A*x的子集，就是把B从A*x的首字母开始一个一个试过去，如果已经把A的每个字母都
    试过了，那么后面就不需要再试了，因为接下来就是再重复一次A了，如果没有子集，再重复下去也没有意义了
    这种解法就属于先找到一些规律，然后再用很简化的代码来实现算法
     */
    public int repeatedStringMatch(String A, String B) {
        int q = 1;//又是起始1或者0，关键还是看把数字代进去看看什么意义。如果下面的for loop没有进行说明A已经比B长了
        //那么q显然是1，因为长度是看A*q，q如果是0就不对了
        StringBuilder sb = new StringBuilder(A);
        for(;sb.length()<B.length();q++) {
            sb.append(A);
        }
        if(sb.indexOf(B)>=0) return q;
        if(sb.append(A).indexOf(B)>=0) return q+1;
        return -1;
    }
}
