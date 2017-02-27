package com.algorithm.devideandconquer;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
	//���merge�������ǹؼ���divide�ܺ���⣬��Ϊ�����ľ��Ƕ���
	public static <T> void merge(T[] a, int p, int q, int r, Comparator<? super T> c) {
		T[] left = Arrays.copyOfRange(a, p, q);
		T[] right = Arrays.copyOfRange(a, q, r);
		int indexLeft = 0;
		int indexRight = 0;
		for (int i = p; i < r; i++) {
			if (indexLeft >= left.length) {
				break;
			}
			if (indexRight >= right.length) {
//				System.arraycopy(left, indexLeft, a, i, left.length - indexLeft);
				break;
			}
			//������merge�ĺ��Ĵ��룬�����������ڸ��Ӷ�Ϊn�ĵ���ѭ�����Ȼ����O�ǹ���n�����Ժ���
			if (c.compare(left[indexLeft], right[indexRight]) < 0) {
				a[i] = left[indexLeft++];
			} else {
				a[i] = right[indexRight++];
			}
		}
	}

	public static <T> void mergeSort(T[] a, int p, int r, Comparator<? super T> c) {
		if (p + 1 < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q, c);
			mergeSort(a, q + 1, r, c);
			merge(a, p, q, r, c);
		}
	}

	public static <T> void mergeSort(T[] a, Comparator<? super T> c) {
		mergeSort(a, 0, a.length, c);
	}

	public static void main(String[] args) {
		// merge's test
		System.out.println("merge method test");
		Integer[] tempMerge = new Integer[] { 1, 4, 7, 11, 14, 17, 2, 4, 6, 8, 10, 20, 30, 40 };
		merge(tempMerge, 0, 6, tempMerge.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i : tempMerge) {
			System.out.print(i + " ");
		}
		System.out.println();
		// mergeSort's test
		System.out.println("mergeSort method test");
		Integer[] tempMergeSoft = new Integer[] { 5, 2, 4, 6, 1, 3, 2, 6 };
		mergeSort(tempMergeSoft, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i : tempMergeSoft) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
