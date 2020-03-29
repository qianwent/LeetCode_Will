package com.leetcode.dynamicprogramming.easy;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return false;
        }
        /**
         * 比较string的典型双指针模式， TODO 暂时没看出来为什么归为DP一类
         */
        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "uuuabc"));
    }
}
