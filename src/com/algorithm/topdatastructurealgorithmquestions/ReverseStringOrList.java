package com.algorithm.topdatastructurealgorithmquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wentao Qian on 12/2/2017.
 */
public class ReverseStringOrList {
    public static  List<Integer> reverseList_wrong(List<Integer> list) {
        int i = 0, j = list.size()-1;
        Integer temp;
        //这个为什么也是错的？即使改成用array来操作？
        // 现在想想，这只是把两个新的变量在一次次地赋值，却从来没有直接更改过array，写成这样简直搞笑
        Integer leftPointer = list.get(i);
        Integer rightPointer = list.get(j);
        while (i<j) {
            temp = list.get(i);
            //variable expected 这种直接是不行的，等同于5=6，显然不合法，至少应该是x=6
            //array可以用array[i]=array[j]直接操作，但是list却不可以，因为list.get(i)是一个方法
            // 返回一个值，value是不能被直接赋值的，只能是variable，这个得牢记啊。。。
//            list.get(i) = list.get(j);
//            list.get(j) = temp;
            leftPointer = rightPointer;
            rightPointer = temp;
            i++;
            j--;
        }
        return list;
    }

    public static  List<Integer> reverseList_v1(List<Integer> list) {
        //再次熟悉array to list
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        int i = 0, j = list.size()-1;
        Integer temp;
        while (i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return Arrays.asList(arr);
    }

    public static  List<Integer> reverseList_v2(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(reverseList_v1(list));
        System.out.println(reverseList_v2(list));
    }

}
