package com.algorithm.topdatastructurealgorithmquestions;

import java.util.LinkedList;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class JavaLinkedList {
    public static void main(String[] args) {
        /*
        由这个例子看出，如果用java.util里定义好的LinkedList，除了比ArrayList多几个方法外，用起来没有太多差别
        所以也就好理解网上其他人关于一般情况下都选ArrayList的观点了
         */
//        List<String> list = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        // Adding elements to the linked list
        list.add("A");
        list.add("B");
        list.addLast("C");
        list.addFirst("D");
        list.add(2, "E");
        list.add("F");
//        list.add("G");
        System.out.println("Linked list : " + list);
        int size = list.size();
        System.out.println(size);
        if(size%2==0) {
            System.out.println("even: " + list.get(size/2-1));
        } else {
            System.out.println("odd: " + list.get((size-1)/2));
        }
    }
}
