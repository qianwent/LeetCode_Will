package com.leetcode.hashtable.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

 If there is no answer, return the empty string.
 Example 1:
 Input:
 words = ["w","wo","wor","worl", "world"]
 Output: "world"
 Explanation:
 The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 Example 2:
 Input:
 words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 Output: "apple"
 Explanation:
 Both "apply" and "apple" can be built from other words in the dictionary.
 However, "apple" is lexicographically smaller than "apply".
 */
public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);//能够有这种思路，应该是千锤百炼的结果。。
        Set<String> set = new HashSet<>();
        String longest = "";
        for(String word: words) {
            if(word.length()==1 || set.contains(word.substring(0, word.length()-1))) {
                longest = word.length() > longest.length() ? word : longest;
                set.add(word);
            }
        }
        return longest;
    }

}
