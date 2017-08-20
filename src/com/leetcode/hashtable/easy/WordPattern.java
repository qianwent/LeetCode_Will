package com.leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 8/20/2017.
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {

    public static void main(String args[]) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String inputStr = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        String inputStr2 = "apple b b c";
        System.out.println(wordPattern(pattern, inputStr));
        System.out.println(wordPattern(pattern, inputStr2));
    }

    public static boolean wordPattern(String pattern, String inputStr) {
        String[] splitWords = inputStr.split(" ");
        if (splitWords.length != pattern.length()) {
            return false;
        }
        Map map = new HashMap();
        for (int i=0; i<pattern.length(); i++) {
            // 如果用 != ，则必须要用Integer， autoboxing-same-value-to-different-objects-problem(没明白。。)
            if (map.put(pattern.charAt(i),i) != map.put(splitWords[i], i)) {
                return false;
            }
        }
        return true;
    }
}
