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

    //����д�����ڶ�������ʽ����Ϥ������£������뵽�ģ�Ӧ��˵��Ȼ������map��������Ȼ���跱��
    //����Ҳ���Ǹ�����Ϥ��char��֪��charû��ʲô�������ã�Ҫת����Сд������Ҫ��String�ķ���toUpperCase()
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
