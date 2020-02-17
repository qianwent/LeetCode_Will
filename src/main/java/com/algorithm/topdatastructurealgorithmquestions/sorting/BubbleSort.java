package com.algorithm.topdatastructurealgorithmquestions.sorting;

import java.util.Arrays;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class BubbleSort {
    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] unsorted = {32, 39,21, 45, 23, 3};
        bubbleSort(unsorted);

        //one more testing of our bubble sort code logic in Java
        int[] test = { 5, 3, 2, 1};
        bubbleSort(test);

    }

    /*
     * In bubble sort we need n-1 iteration to sort n elements
     * at end of first iteration largest number is sorted and subsequently numbers smaller
     * than that.
     * ��νð�����򣬺���˼������õ�ǰloop���������ð��һ������ˮ�棬�ͷŵ����һ��
     * ��һ��loop������Ҳ���ǰ����ڵ������������˸��飬�����һ����һ����������������
     * ��һ�֣��������ڵ������Ƚ���һ�飬ÿ�ζ��ǰѴ���������ƶ�
     * Ȼ��ʼ�ڶ���loop���ٰѵ�ǰ��������ŵ����
     * ע�⣺��ѭ��ÿѭ��һ�Σ���ѭ����Ҫ�Ƚϵ�������һ������Ϊ��һ���Ѿ��������ð�ݳ�����
     * ������ѭ����Ȼ��j<unsorted.length -i
     * ֱ��ÿһ��loop���Ƚ��꣬���������������ð�˳�����Ҳ�ʹﵽ�������Ŀ��
     */
    public static void bubbleSort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

        // Outer loop - need n-1 iteration to sort n elements
        //ע������Ϊʲôֻ��ѭ��n-1�Σ�������������ɻ�ֻҪ���Ǽ������������ֻ��2����
        //����Ȼֻ�ñȽ�һ�Σ�Ȼ����ɷ������֪��Ҫѭ��n-1��
        //���һ��ı���һ�����ݣ���ÿ������modify���ǲ�һ����
        for(int i=0; i<unsorted.length -1; i++){

            //Inner loop to perform comparision and swapping between adjacent numbers
            //After each iteration one index from last is sorted
            for(int j= 1; j<unsorted.length -i; j++){

                //If current number is greater than swap those two
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.printf("unsorted array after %d pass %s: %n", i+1, Arrays.toString(unsorted));
        }
    }

}
