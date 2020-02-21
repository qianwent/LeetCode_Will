package com.book.algorithm4thedition.chapter2.a2_1;

import static com.book.algorithm4thedition.chapter2.Example.*;

public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j-1, j);
            }
        }
    }
}
