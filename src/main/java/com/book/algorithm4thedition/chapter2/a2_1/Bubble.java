package com.book.algorithm4thedition.chapter2.a2_1;

import static com.book.algorithm4thedition.chapter2.Example.*;

public class Bubble {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (less(a[j], a[j-1])) { // swap adjacent numbers
                    exch(a, j-1, j);
                }
            }
        }
    }
}
