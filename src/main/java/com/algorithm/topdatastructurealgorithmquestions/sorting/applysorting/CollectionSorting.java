package com.algorithm.topdatastructurealgorithmquestions.sorting.applysorting;

import java.util.*;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
public class CollectionSorting {
    public static void main(String[] args) {
        //basic sorting using Collections utility
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        Collections.sort(list);
        System.out.println(list);

        //sorting using Comparator
        List<SmartPhone> phoneList = SmartPhone.getSmartPhoneList();
        System.out.println("Actual List");
        System.out.println(phoneList);
        System.out.println("Sorting the list as comparator");
//        Collections.sort(phoneList, new RatingComparator());
        //ֱ����lambda���ʽ����࣬����Ҳ������һЩ��������Ϊ������ʽʵ������һ������comparator��ʵ��
        Collections.sort(phoneList, (o1, o2) -> o1.getRating()<o2.getRating() ? -1 : o1.getRating()>o2.getRating() ? 1 :0);

        System.out.println(phoneList);
        System.out.println("Reversing the Comparator sorting");
        Comparator<SmartPhone> cmp = Collections.reverseOrder(new RatingComparator());

        Collections.sort(phoneList, cmp);
        System.out.println("Printing the reverse list");
        System.out.println(phoneList);

        //���ֱ��ʽ��Ҫ����Ҳ����
        //this is called Method Reference
        //https://netjs.blogspot.com/2015/06/method-reference-in-java-8.html
        Collections.sort(phoneList, SmartPhone::compareTo);
        System.out.println(phoneList);
    }
}
