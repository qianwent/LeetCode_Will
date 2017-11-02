package com.leetcode.hashtable.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ǵ�һ���Ӵ���sliding window���͵��㷨������˼��������ָ����ƶ�
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash---���ʵ���������г�ʼ��Ϊ0
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;//����������Ǳ��һ�£�p����ڵ��ַ������ͱ��Ϊ1����ȷʵ��һ�����ó�ʼ������ĺܺ�����
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            //����һ��ʼû����--������Ϊû��������һ��forѭ�����������壬indexΪ97-99�Ķ������Ϊ1����������0�����������Java�����char������֮һ
            //����ҵ�������ַ�������hash����1��Ҫ���¿�ʼ��һ��ѭ����������㣬�Ǿ��Ʊ�Ҫ--��ע�⣬�����Ѿ��������ˣ��������ǹ�����ô�򵥣�
            //ʵ�������--�������Ǽ�¼����������p�е��ַ��ظ������ٴ��ˣ��ڸı���ֵ��һֱ��hash���飬������p
            //��Ϊ������ÿ���ַ�ֻ����һ�Σ��������ǰ���������3��a����ôhash['a']Ҳ����hash[97]�ͱ����-2��
            //Ȼ������������ƣ����ָ������֮���ʼ��a��Ȼ���޳��ˣ���ôhash[97]�ûص�-1��Ȼ���ٿ����Ƶ��ұ�ָ�룬
            //�������a����ôhash[97]�ٴ�-1���-2���������a����ı�����index�µ�ֵ��Ȼ���ֿ�ʼ֮ǰ��ѭ�����ȿ��ַ��Ƿ��p�е�ƥ�䣬
            //ֻҪƥ�䣬count--��ֱ����ȫƥ�䣬count=0��left��λ�þͿ������
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;

    }

    public static void main(String args[]) {
//        String s = "cbaebabacd";
        String s = "aaaaaaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

}
