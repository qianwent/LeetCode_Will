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
         * �����ü��޵�˼ά����������������������ȡRBWR
         * ��һ�αȽϺ�RB���н������BR���ڶ�����Ϊi++�ˣ����ԱȽ�W�ͻ�׼��R������������WR�����RW
         * �����֮��Ҫ��������򣬾��Ǻ���Ȼa[lo..lt-1]������<v�ģ�a[gt+1..hi]����>v��
         * ��˱߽��ȷ����
         * ȷ���߽��ʱ�������������ݹ�һ���Ƿǳ����ٵķ�ʽ
          */
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
