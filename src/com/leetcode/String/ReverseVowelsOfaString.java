package com.leetcode.String;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfaString {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] charsInString = s.toCharArray();
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        while(leftPointer<rightPointer) {
            while (leftPointer < rightPointer && !vowels.contains(charsInString[leftPointer] + "")) {
                leftPointer++;
            }
            while (leftPointer < rightPointer && !vowels.contains(charsInString[rightPointer] + "")) {
                rightPointer--;
            }
            char temp = charsInString[leftPointer];
            charsInString[leftPointer] = charsInString[rightPointer];
            charsInString[rightPointer] = temp;
            //显然这里也要再次移动pointer，因为之前的两个while loop在拿到vowel的时候指针停止移动了
            leftPointer++;
            rightPointer--;
        }
        return new String(charsInString);
//        return charsInString.toString();//toString方法显然不是array转成string的方法
        //区别对待list(of Integer) to array(of int) 和 char[] to String，目前还是容易混淆，还不熟练
        //对比 hashtable\easy\IntersectionOfTwoArrays.java 的注释
    }

    public String reverseVowels_v0(String s) {
        String vowels = "aeiouAEIOU";
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        while(leftPointer<rightPointer) {
            while(leftPointer<rightPointer && !vowels.contains(s.charAt(leftPointer)+"")) {
                leftPointer++;
            }
            while(leftPointer<rightPointer && !vowels.contains(s.charAt(rightPointer)+"")) {
                rightPointer--;
            }
            //刚开始的思路，以后回顾错误思路的时候，会有感触的吧
            //首先应该知道string是immutable的，那怎么换字符，都还是那个string
            //所以自然而然应该想到把string转成char[]，用array操作
        }
        return s;
    }

}
