package com.leetcode.String.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    //回顾一下two pointer算法，细节方面只要注意大小写是否有限制
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        char leftChar, rightChar;
        while(leftPointer <= rightPointer) {
            leftChar = s.charAt(leftPointer);
            rightChar = s.charAt(rightPointer);
            if(!Character.isLetterOrDigit(leftChar)) {
                leftPointer++;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                rightPointer--;
            } else {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
                leftPointer++;
                rightPointer--;
            }
        }
        return true;
    }

}
