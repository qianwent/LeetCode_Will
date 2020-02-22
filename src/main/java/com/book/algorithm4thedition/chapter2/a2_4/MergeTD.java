package com.book.algorithm4thedition.chapter2.a2_4;

import static com.book.algorithm4thedition.chapter2.Example.less;

public class MergeTD {

    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // sort a[lo...hi]
        if (hi<=lo) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid); // sort left half
        sort(a, mid + 1, hi); // sort right half
        merge_v2(a, lo, mid, hi); // merge results
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

    // while loop, no big difference
    private static void merge_v2(Comparable[] a, int lo, int mid, int hi) {
        int k = lo;
        int i = lo, j = mid + 1;
        for (int q = lo; q <= hi; q++) {
            aux[q] = a[q];
        }
        while (k <= hi) {
            if (i > mid) {
                a[k++] = aux[j++];
            } else if (j > hi) {
                a[k++] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k++] = aux[j++];
            } else {
                a[k++] = aux[i++];
            }
        }
    }
}
