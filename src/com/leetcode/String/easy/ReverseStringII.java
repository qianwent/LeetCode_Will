package com.leetcode.String.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        //一开始看到reverse，有2个选择，要么用Java自带的reverse方法，要么自己写一个reverse
        //经对比，发现reverse是来自于StringBuilder的，那反而复杂化了
        char[] chars = s.toCharArray();
        int i = 0;
        int n = s.length();//注意不是上手就写-1的
        while (i<n) {
            int j = Math.min(i+k-1, n-1);
            swap(chars, i, j);
            i+=2*k;
        }
        return String.valueOf(chars);
    }

    //这就是reverse一个数组的定式！
    private void swap(char[] chars, int i, int j) {
        while (i<j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }

}
