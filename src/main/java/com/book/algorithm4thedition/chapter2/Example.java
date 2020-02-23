package com.book.algorithm4thedition.chapter2;

import com.book.algorithm4thedition.chapter2.a2_1.Bubble;
import com.book.algorithm4thedition.chapter2.a2_1.Insertion;
import com.book.algorithm4thedition.chapter2.a2_1.Selection;
import com.book.algorithm4thedition.chapter2.a2_1.Shell;
import com.book.algorithm4thedition.chapter2.a2_4.MergeBU;
import com.book.algorithm4thedition.chapter2.a2_4.MergeTD;
import com.book.algorithm4thedition.chapter2.a2_5.Quick;
import com.book.algorithm4thedition.chapter2.a2_5.Quick3Way;

public class Example {

    public static void sort(Comparable[] a) {
        // different algorithms would be applied here
//        Bubble.sort(a);
//        Selection.sort(a);
//        Insertion.sort(a);
//        Shell.sort(a);
//        MergeTD.sort(a);
//        MergeBU.sort(a);
//        Quick.sort(a);
        Quick3Way.sort(a);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = new In().read();
        sort(strings);
        System.out.println(isSorted(strings));
        show(strings);
    }
}
