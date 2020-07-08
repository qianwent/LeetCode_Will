package com.leetcode.dynamicprogramming.medium;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {

    int count = 0;

    /**
     * 最容易想到的当然是two-pointer
     * 加上题中明确了，substring如果是不同的index算作不相同，减少了思考的难度
     * 一个遍历，然后每个i都往两边extend
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    /**
     * 再看一下DP的解，关键在于状态转移方程
     * dp[i][j]这里定义为是否是palindromic substring，即boolean
     * 容易得到dp[i][j]=s[i]==s[j]&&(j-j<3||dp[i+1][j-1])
     */
    public int countSubstrings_DP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        /**
         * loop的条件判断，一开始会搞混，其实还是对DP的定义和思路不敏感
         * 状态转移方程，首先有个很重要的概念就是要通过求解子问题来得到更大问题的解
         * 比如dp[i][j]和dp[i+1][j-1]，后者显然是前者的一个子集
         * 那么，在双重loop之后要达到的效果就应该是先得到子问题的dp值
         * 如果外循环i是从0开始，那么在计算dp[0][3]开始，就需要dp[1][2]，但是这个显然没有计算过
         * 而如果外循环i是从n-1开始，就会把dp[4][4],dp[3][3],dp[3][4],dp[2][2],dp[2][3]等依次计算并保存
         * 直到dp[1][4]的时候，需要调用dp[2][3]，这个值已经计算过了，从而得到正确的解
         * note：对于双循环每层遍历的顺序问题，其实就跟边界状态的确定差不多的意思，罗列一下具体的数值，就能看出，而不是一上来就凭感觉
         */
//        for (int i = 0; i < n; i++) { // this is wrong
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("aaaaa"));
        System.out.println(ps.countSubstrings_DP("aaaaa"));
    }
}
