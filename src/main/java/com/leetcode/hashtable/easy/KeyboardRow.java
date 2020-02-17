package com.leetcode.hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 */
public class KeyboardRow {

    //这种写法是在对正则表达式不熟悉的情况下，首先想到的，应该说虽然运用了map，但是任然步骤繁多
    //不过也算是更加熟悉了char，知道char没有什么方法可用，要转换大小写，则需要用String的方法toUpperCase()
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            for(char c: strs[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> list = new ArrayList<>();
        for(String word: words) {
            int firstLetterIndex = map.get(word.toUpperCase().charAt(0));//char doesn't have method
            for(char c: word.toUpperCase().toCharArray()) {
                if(map.get(c)!=firstLetterIndex) {
                    firstLetterIndex = -1;
                    break;
                }
            }
            if(firstLetterIndex!=-1) {
                list.add(word);
            }
        }
//        return list.toArray(new String[list.size()]);
        return list.stream().toArray(String[]::new);
    }

}
