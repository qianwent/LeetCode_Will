package com.book.algorithm4thedition.chapter2.a2_1;

import static com.book.algorithm4thedition.chapter2.Example.*;

/**
 * Faster than Insertion sort TODO
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j-h, j);
                }
            }
            h = h / 3;
        }
    }
}
