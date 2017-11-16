package com.leetcode.String.stringdatastructure;

/**
 * Created by Wentao Qian on 11/16/2017.
 */
public class StringManipulation {

    public static void main(String[] args) {
        String s = " a b c ";
        System.out.println("---" + s + "---");
        //trim方法是用来去头去尾的
        System.out.println("---" + s.trim() + "---");
        s = s + 1;
        System.out.println(s);
        s+=1;
        System.out.println(s);
        //至此是看不出string immutable的

        //这个例子就能看出immutable了
        //TODO：那有什么意义呢？意义重大！
        /*
        如下面例子，比如s1存放的是一个文件路径，s2复制过来，并在另一个方法中使用，缓存(hashcode可以被缓存)
        如果这个时候s1因为其他程序或方法的调用指向了另一个文件路径，那么s2的值不能改变，因为调用s2的方法
        和调用s1的方法没有关联，如果string设计成mutable，那么上述case就会出现安全问题
        这里延伸出另一个问题：TODO 自己在程序中从来没有用过immutable object，因为从来没有涉及过任何同步和线程安全问题
        http://www.infoq.com/cn/articles/java-multithreaded-programming-mode-immutable-object/
        这个网站的例子很好地解释了什么情况下用immutable object模式最合适
        不可变对象具有天生的线程安全性，多个线程共享一个不可变对象的时候无需使用额外的并发访问控制，
        这使得我们可以避免显式锁（Explicit Lock）等并发访问控制的开销和问题，简化了多线程编程。
         */
        String s1 = "abc";
        String s2 = s1;
        s1 += 1;
        System.out.println("s1 " + s1);
        System.out.println("s2 " + s2);
        //对比StringBuilder，效果就不同了，改变sb1，sb2也一起改变了，说明是mutable
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = sb1;
        sb1 = sb1.append("1");
        System.out.println("sb1 " + sb1);
        System.out.println("sb2 " + sb2);

    }

}
