package com.leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.

 ***No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic_v2(String s, String t) {
        if(s.length()==1) return true;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                //多出这个逻辑，主要是因为有这么一个限制
                //***No two characters may map to the same character but a character may map to itself.
                //如果有同样的value，而且第二个key还没有加入到map中，那么这种情况就不符合上面的描述，false
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

}
