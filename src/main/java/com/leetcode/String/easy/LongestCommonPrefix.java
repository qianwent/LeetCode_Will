package com.leetcode.String.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    //先预习一下string的一些基本方法
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bc";
        int index1 = s1.indexOf(s2);//if it is a substring, then return the index of the first matching character
        System.out.println(index1);
        int index0 = s1.indexOf("fds");//otherwise return -1
        System.out.println(index0);
        int index2 = s2.indexOf(s1);
        System.out.println(index2);
        String s3 = "ab";
        System.out.println("abc in ab " + s3.indexOf(s1));
        System.out.println("substring of ab---" + s3.substring(0,1));
        boolean b1 = s1.startsWith("a");
        System.out.println(b1);

        String[] strs = {"abcd", "ab"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs==null) return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            //while循环目前看来是非常不熟练，跟for循环的差别还是非常明显的，如果不满足条件将一直循环下去
            //不想for循环，总会停下来的
            //所以在实际项目中，特别是那个kafka的项目，要不断读取MQ中的数据，就用了while(true)，无限循环
            //那这里的while循环，经过debug，很快明白只要不是substring，就继续循环，除非子集是空
            //空的话也就没必要再进行下去了，这也解决了无限循环的问题
            while (strs[i].indexOf(prefix)!=0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
