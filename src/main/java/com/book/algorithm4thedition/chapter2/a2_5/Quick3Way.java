package com.book.algorithm4thedition.chapter2.a2_5;

import static com.book.algorithm4thedition.chapter2.Example.exch;

/**
 * if having lots of duplicate values, Quick3Way is more efficient than Quick sort
 */
public class Quick3Way {

    public static void sort(Comparable[] a) {
        //shuffle the array TODO
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, i++, lt++);
            } else if (cmp > 0) {
                exch(a, gt--, i);// why here not i++, because here we don't know the value of a[gt], after exchange, we still need to check this value
            } else {
                i++;
            }
        }// now we have a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]
        /**
         * it's tricky to understand right bound is lt-1 when coding first time
         * however after thinking, it should be easy to figure out
         * 还是用极限的思维，配合最少量的数，这里就取RBWR
         * 第一次比较后，RB进行交换变成BR，第二次因为i++了，所以比较W和基准数R，交换后两个WR，变成RW
         * 那这个之后，要对左边排序，就是很显然a[lo..lt-1]是满足<v的，a[gt+1..hi]满足>v的
         * 因此边界就确定了
         * 确定边界的时候用少量的数据过一遍是非常快速的方式
          */
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
