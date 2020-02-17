package com.javabasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao Qian on 11/26/2017.
 */
public class StackAndHeap {
    /*
        写Java这么长时间，总是知道StackOverflow错误的，那么现在就来总结一下，Stack这个数据结构
        含义一：数据结构
        Last in, first out，LIFO
        与这种结构配套的，是一些特定的方法，主要为下面这些。
        push：在最顶层加入数据。
        pop：返回并移除最顶层的数据。
        top：返回最顶层数据的值，但不移除它。
        isempty：返回一个布尔值，表示当前stack是否为空栈。
        含义二：代码运行方式
        stack的第二种含义是"调用栈"（call stack），表示函数或子例程像堆积木一样存放，以实现层层调用。
        含义三：内存区域
        stack的第三种含义是存放数据的一种内存区域。程序运行的时候，需要内存空间存放数据。
        一般来说，系统会划分出两种不同的内存空间：一种叫做stack（栈），另一种叫做heap（堆）。
        它们的主要区别是：stack是有结构的，每个区块按照一定次序存放，可以明确知道每个区块的大小；
        heap是没有结构的，数据可以任意存放。因此，stack的寻址速度要快于heap。
        其他的区别还有，一般来说，每个线程分配一个stack，每个进程分配一个heap，
        也就是说，stack是线程独占的，heap是线程共用的。此外，stack创建的时候，大小是确定的，数据超过这个大小，
        就发生stack overflow错误，而heap的大小是不确定的，需要的话可以不断增加。
        根据上面这些区别，数据存放的规则是：只要是局部的、占用空间确定的数据，一般都存放在stack里面，否则就放在heap里面。
     */
    //一般来说，StackOverflow最容易的实现方式是recursion
    private static void method() {
//        System.out.println("method");
        method();//Exception in thread "main" java.lang.StackOverflowError
    }

    public static void main(String[] args) {
        method();

        //在重现OutOfMemoryError前，需要设置VM Args: -Xms20m -Xmx20m (限制堆的大小不可扩展)
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        List<Object> list=new ArrayList<>();
        // 不断创建对象，并保证GC Roots到对象之间有可达路径，避免垃圾回收清除创建的对象
        while (true) {
            list.add(new OOMObject());
//            System.out.println(System.currentTimeMillis());
        }
    }

    public static class OOMObject {
    }
}
