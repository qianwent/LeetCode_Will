package com.leetcode.hashtable.easy;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for(int i=0; i<s.length(); i++) {
            //还是这里不够熟练，既然为26个小写字母定义了26个元素的数组，
            // 那就得明白alphabets[i]里的i不能超过25，如果用s.charAt(i)，
            // 那第一个字母a，转成int就是97，java.lang.ArrayIndexOutOfBoundsException: 97
            //所以s.charAt(i)-'a'，保证了index在0-25
            //这可以算是涉及到字母是否重复，是否含有之类的题目的通用解题思路
            //虽然按照字符串每个字母的顺序遍历，但是在插入和读取之前定义的数组的时候却不是按照这个顺序
            //这点之前有思维定式，认为for loop就是按照i的顺序，依次下来，而忽略了数组的index实际并不是按照顺序来的
            //不要愚蠢地认为，i就是index。。。
            //程序世界里有太多这种同名，却不同意义的变量，实战时候也要注意
            alphabets[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            alphabets[t.charAt(i)-'a']--;
        }
        for(int c : alphabets) {
            if(c!=0) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";
        boolean bb = isAnagram(s, t);
        System.out.println(bb);

        //以下这个例子，跟Java内存原理相关，了解一下即可
        char a = 'a';
//        char b = a + 18;//这个是不能通过编译的
//        char b = a + 'c';//这个也不行，比较容易理解的是在运算的时候a是一个变量，分配给它的内存空间和'b'是不一样的
        char b = (char)(a + 'c');
        /* 以下是一些题外话，有个概念
        https://zhidao.baidu.com/question/548867581.html
        其实char a和'a'不是一回事。就像'a'+18 和b+18不是一回事一样。'a'这个东西是一个常量值（你不要看到'a'就以为它是char类型，
        其实这里写'a'和97是一样的，默认都是int类型的常量，仅仅加上单引号是为了告诉我们这里面只能放char规定范围的数值）。
        而你定义了char a='a'这就不一样了，这个a是变量，仅仅是把常量的值赋给变量，这个是'a'这个int值传递给了char，
        这时候a就是char类型了。char类型与18进行运算，当然得到的结果就是int型，而且必须是int型的内存块。
     ‘a’+18其实是两个int型的常量进行运算，然后生成一个新的int类型的常量。
     传递给b的是一个常量值（常量不可改变，变量可以改变），常量的值赋给变量，不存在强制转换，
     只要这个变量的类型值能够容纳这个新的常量即可。理解这个，你就需要理解常量不可改变这一点上，
     两个新的常量相加会生成一个新的常量。而变量与常量相加会形成一个新的变量值。
    而a+18，其实a已经分配了一个内存空间用存放char类型变量a（记着，a是变量，值可以改变，常量值不可以改变，而且a是char类型），
    然后把a复制一份放到内存，然后用复制的值的与int类型的常量18进行运算，
    这时候生成是一个变量值（没有标注，但是一定有一个变量来存放它），然后把这个变量值赋给变量b，
    因为是变量，存在着类型转换问题。原理是因为a与18分别处于不同的内存块当中，这时候传递给b的是2个内存空间的值，
    这时候就存在着转换问题了。
    其实，你只要理解了常量和变量的内存模型，这个问题就理解了。

     至于具体的解释，可以看看马士兵老师的java基础教程，这里面对这种转换又十分合理的解释。
 我的解释不站在内存分配上是很难解释的。
         */
    }

}
