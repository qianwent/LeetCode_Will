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
     * �������뵽�ĵ�Ȼ��two-pointer
     * ����������ȷ�ˣ�substring����ǲ�ͬ��index��������ͬ��������˼�����Ѷ�
     * һ��������Ȼ��ÿ��i��������extend
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
     * �ٿ�һ��DP�Ľ⣬�ؼ�����״̬ת�Ʒ���
     * dp[i][j]���ﶨ��Ϊ�Ƿ���palindromic substring����boolean
     * ���׵õ�dp[i][j]=s[i]==s[j]&&(j-j<3||dp[i+1][j-1])
     */
    public int countSubstrings_DP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        /**
         * loop�������жϣ�һ��ʼ���죬��ʵ���Ƕ�DP�Ķ����˼·������
         * ״̬ת�Ʒ��̣������и�����Ҫ�ĸ������Ҫͨ��������������õ���������Ľ�
         * ����dp[i][j]��dp[i+1][j-1]��������Ȼ��ǰ�ߵ�һ���Ӽ�
         * ��ô����˫��loop֮��Ҫ�ﵽ��Ч����Ӧ�����ȵõ��������dpֵ
         * �����ѭ��i�Ǵ�0��ʼ����ô�ڼ���dp[0][3]��ʼ������Ҫdp[1][2]�����������Ȼû�м����
         * �������ѭ��i�Ǵ�n-1��ʼ���ͻ��dp[4][4],dp[3][3],dp[3][4],dp[2][2],dp[2][3]�����μ��㲢����
         * ֱ��dp[1][4]��ʱ����Ҫ����dp[2][3]�����ֵ�Ѿ�������ˣ��Ӷ��õ���ȷ�Ľ�
         * note������˫ѭ��ÿ�������˳�����⣬��ʵ�͸��߽�״̬��ȷ��������˼������һ�¾������ֵ�����ܿ�����������һ������ƾ�о�
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
