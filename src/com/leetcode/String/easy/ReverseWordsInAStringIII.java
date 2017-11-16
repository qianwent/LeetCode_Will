package com.leetcode.String.easy;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {

    //这个算法虽然代码行数增加了，但是效率却是大大提高，因为没有stream的参与
    public String reverseWords(String s) {
        if(s.length()==0 || s == null) return "";
        String[] strArray = s.split(" ");
        for(int i=0; i<strArray.length; i++) {
            strArray[i] = new StringBuilder(strArray[i]).reverse().toString()+" ";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strArray) {
            sb.append(str);
        }
        return sb.toString().trim();//再次注意，trim方法的注释，去头去尾
        //Returns a string whose value is this string, with any leading and trailing whitespace removed.
    }

    //这是最开始用lambda来写，效率比较低下，且不管是StringBuilder还是StringBuffer，并不根本性地影响效率
    //TODO：那么我们可以说下面stream的加入，使得效率变得低下了，但是具体是怎么变低下的，还需要研究
    public String reverseWords_v0(String s) {
        if(s.length()==0 || s == null) return "";
        String[] strArray = s.split(" ");
        return Arrays.stream(strArray).map(i -> {
            i = new StringBuilder(i).reverse().toString() + " ";
            return i;
        }).collect(Collectors.joining()).trim();
//        }).collect(Collectors.joining()).substring(0,s.length());
    }

}
