package com.book.algorithm4thedition.chapter2.a2_1;

import static com.book.algorithm4thedition.chapter2.Example.*;

/**
 * Selection sort
 * loop for N times, each time find the smallest value, and exchange with the first value in current loop
 * No stable, for example, [5,8,5,2,9], after first loop, 5[0]->5[3], which moves after 5[2], thus not stable, as these two 5s might link to different values
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;// this is to find the index of smallest value
                }
            }
            exch(a, i, min);
        }
    }
}
