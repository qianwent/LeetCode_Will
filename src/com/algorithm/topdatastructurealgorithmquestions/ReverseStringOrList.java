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
        //���ΪʲôҲ�Ǵ�ģ���ʹ�ĳ���array��������
        // �������룬��ֻ�ǰ������µı�����һ�δεظ�ֵ��ȴ����û��ֱ�Ӹ��Ĺ�array��д��������ֱ��Ц
        Integer leftPointer = list.get(i);
        Integer rightPointer = list.get(j);
        while (i<j) {
            temp = list.get(i);
            //variable expected ����ֱ���ǲ��еģ���ͬ��5=6����Ȼ���Ϸ�������Ӧ����x=6
            //array������array[i]=array[j]ֱ�Ӳ���������listȴ�����ԣ���Ϊlist.get(i)��һ������
            // ����һ��ֵ��value�ǲ��ܱ�ֱ�Ӹ�ֵ�ģ�ֻ����variable��������μǰ�������
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
        //�ٴ���Ϥarray to list
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
