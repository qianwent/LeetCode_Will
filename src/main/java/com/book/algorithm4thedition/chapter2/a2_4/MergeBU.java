package com.book.algorithm4thedition.chapter2.a2_4;

import static com.book.algorithm4thedition.chapter2.Example.less;

/**
 * Bottom-up mergesort
 */
public class MergeBU {

    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // merge a[lo..mid] with a[mid+1..hi]
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];// copy a[lo..hi] to aux[lo..hi]
        }

        for (int k = lo; k <= hi; k++) { // merge back to a[lo..hi]
            if (i>mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
