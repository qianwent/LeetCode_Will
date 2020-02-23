package com.book.algorithm4thedition.chapter2.a2_5;

import com.book.algorithm4thedition.chapter2.a2_1.Insertion;

import static com.book.algorithm4thedition.chapter2.Example.exch;
import static com.book.algorithm4thedition.chapter2.Example.less;

public class Quick {

    private static int M = 5;

    public static void sort(Comparable[] a) {
        //shuffle the array TODO
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) { // this could be improved by using Insertion sort if subarray size is small
            return;
        }
//        if (hi <= lo + M) {
//            Insertion.sort(a);
//            return;
//        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo]; // partitioning item, first element, after shuffle
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
