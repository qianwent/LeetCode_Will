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
     * 所谓冒泡排序，核心思想就是让当前loop的最大数像冒泡一样浮出水面，就放到最后一个
     * 第一个loop结束，也就是把毗邻的数都挨个比了个遍，那最后一个数一定是这里面最大的了
     * 这一轮，所有相邻的数都比较了一遍，每次都是把大的数往后移动
     * 然后开始第二轮loop，再把当前的最大数排到最后
     * 注意：外循环每循环一次，内循环需要比较的数就少一个，因为上一轮已经把最大数冒泡出来了
     * 所以内循环必然是j<unsorted.length -i
     * 直到每一轮loop都比较完，所有最大数都依次冒了出来，也就达到了排序的目的
     */
    public static void bubbleSort(int[] unsorted){
        System.out.println("unsorted array before sorting : " + Arrays.toString(unsorted));

        // Outer loop - need n-1 iteration to sort n elements
        //注意这里为什么只用循环n-1次，如果出现这种疑惑，只要考虑极限情况，比如只有2个数
        //那显然只用比较一次，然后归纳法你就能知道要循环n-1次
        //这和一般的遍历一串数据，对每个数据modify，是不一样的
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
