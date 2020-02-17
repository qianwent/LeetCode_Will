package com.leetcode.String.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

    /*
    本题解法为greedy algorithm
    贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。
    也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。
贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，
即某个状态以前的过程不会影响以后的状态，只与当前状态有关。
    注意：这种算法是特殊条件下才能使用，并不一定能给出最优解，这个后续碰到再看 TODO
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        //有这种左右指针往中间夹逼的，while循环再合适不过了
        while (i<j && s.charAt(i)==s.charAt(j)) {//再次熟悉string的charAt方法
            i++;
            j--;
        }
        if (i>=j) return true;
        if (isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1)) return true;
        return false;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

}
