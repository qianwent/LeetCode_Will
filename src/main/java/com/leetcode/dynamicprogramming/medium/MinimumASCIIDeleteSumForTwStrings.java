package com.leetcode.dynamicprogramming.medium;

/**
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * Example 1:
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * Example 2:
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 * Note:
 *
 * 0 < s1.length, s2.length <= 1000.
 * All elements of each string will have an ASCII value in [97, 122].
 */
public class MinimumASCIIDeleteSumForTwStrings {

    public static int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        int sum = 0;

        for (int i = 0; i < l1; i++) {
            int c1 = s1.charAt(i);
            sum += c1;

            for (int j = 0; j < l2; j++) {
                int c2 = s2.charAt(j);
                if (i == 0) {
                    sum += c2;
                }
                /**
                 * 经典的LCS算法，分段函数
                 * dp[i][j]表示s1前i个元素和s2前j个元素间的LCS
                 */
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + c1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return sum - dp[l1][l2] * 2;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
    }
}
