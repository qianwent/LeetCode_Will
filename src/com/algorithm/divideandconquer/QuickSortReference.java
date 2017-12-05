package com.algorithm.divideandconquer;

import com.algorithm.topdatastructurealgorithmquestions.sorting.QuickSort;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class QuickSortReference {
    public static void main(String[] args) {
        int array[] = {10,5,3,1,7,2,8};
        QuickSort.quickSort(array, 0, array.length-1);
        for(int i: array) {
            System.out.print(i + " ");
        }
    }
}
