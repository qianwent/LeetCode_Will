package com.algorithm.topdatastructurealgorithmquestions.sorting;

import java.util.LinkedList;

/**
 * Created by Wentao Qian on 12/6/2017.
 */
public class InsertionSortingInterviewTest<E extends Comparable> {
    //TODO: 这里generic用得对不对还有待考量
    private LinkedList<E> sSorted = new LinkedList<>();

    public void addElement(E e) {
        // TODO: Insert e to sSorted and make sure sSorted is always sorted.
        int i = 0;
        for(E integer : sSorted) {
            if(e.compareTo(integer)>0) {//TODO:至少这里我们不能直接比较泛型大小，需要用到compareTo
                break;
            }
            i++;
        }
        sSorted.add(i, e);
    }

    public static void main(String[] args) {
        InsertionSortingInterviewTest<Integer> linkedListCustom = new InsertionSortingInterviewTest();
        linkedListCustom.addElement(3);
        System.out.println(linkedListCustom.sSorted);
        linkedListCustom.addElement(1);
        System.out.println(linkedListCustom.sSorted);
        linkedListCustom.addElement(5);
        System.out.println(linkedListCustom.sSorted);
        linkedListCustom.addElement(2);
        System.out.println(linkedListCustom.sSorted);
        linkedListCustom.addElement(0);
        System.out.println(linkedListCustom.sSorted);

    }
}
