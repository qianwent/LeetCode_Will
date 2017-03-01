package com.leetcode.array;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//把两个sorted array merge起来变成一个新的sorted array
	//以下是经典算法，因为是array，定长，所以无论从最大还是最小值开始比较都可以
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int a = m+n-1;
		while(m>0&&n>0) {
			nums1[a--] = (nums1[m-1]>nums2[n-1]) ? nums1[m---1] : nums2[n---1];
		}
		while(n>0) {
			nums1[a--] = nums2[n---1];
		}
		
	}

}
