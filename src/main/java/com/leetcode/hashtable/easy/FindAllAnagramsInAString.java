package com.leetcode.hashtable.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是第一个接触的sliding window类型的算法，基本思想是左右指针的移动
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
        int[] hash = new int[256]; //character hash---这个实际上是所有初始化为0
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;//到了这里就是标记一下，p里存在的字符串，就标记为1。这确实是一个利用初始化数组的很好列子
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            //这里一开始没看懂--，是因为没看懂上面一个for循环的真正含义，index为97-99的都被标记为1，其他都是0，这个看来是Java数组和char的特性之一
            //如果找到了这个字符串，那hash就是1，要重新开始下一次循环，必须归零，那就势必要--（注意，这里已经理解错误了，不仅仅是归零这么简单）
            //实际上这个--的作用是记录本来存在于p中的字符重复过多少次了，在改变数值的一直是hash数组，而不是p
            //因为题意是每个字符只能用一次，那如果当前这个窗口有3个a，那么hash['a']也就是hash[97]就变成了-2，
            //然后如果窗口右移，左边指针右移之后，最开始的a显然被剔除了，那么hash[97]得回到-1，然后再看右移的右边指针，
            //如果还是a，那么hash[97]再次-1变成-2，如果不是a，则改变其他index下的值，然后又开始之前的循环，先看字符是否和p中的匹配，
            //只要匹配，count--，直到完全匹配，count=0，left的位置就可以输出
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
