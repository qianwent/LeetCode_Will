package com.algorithm.topdatastructurealgorithmquestions;

import java.util.LinkedList;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class JavaLinkedList {
    public static void main(String[] args) {
        /*
        ��������ӿ����������java.util�ﶨ��õ�LinkedList�����˱�ArrayList�༸�������⣬������û��̫����
        ����Ҳ�ͺ�������������˹���һ������¶�ѡArrayList�Ĺ۵���
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
