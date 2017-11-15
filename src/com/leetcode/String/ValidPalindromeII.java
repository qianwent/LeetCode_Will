package com.leetcode.String;

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
