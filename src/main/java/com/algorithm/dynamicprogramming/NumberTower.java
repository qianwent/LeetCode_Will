package com.algorithm.dynamicprogramming;

public class NumberTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		NumberTower nt = new NumberTower();
		int dpMax = nt.maxSum(arr);
		System.out.println(dpMax);
		
		int[][] arr2 = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		int[] dpMaxArr = nt.maxSumTopToBottom(arr2);
		for(int i:dpMaxArr) {
			System.out.println(i);
		}
		
	}
	
	public int maxSum(int[][] arr) {
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				arr[i-1][j] += max(arr[i][j], arr[i][j+1]);
			}
		}
		return arr[0][0];
	}
	
	public int max(int i1, int i2) {
		return i1>i2?i1:i2;
	}
	
	public int[] maxSumTopToBottom(int[][] arr) {
		//�Ӷ������£��������ٷ���ÿ���������һ�飬��ͺ�������һ��������һ����������һ������ͬ����һ�����в�ͬ����һ������ѡ����β������ţ�
		//�����㷨�õ����Ƕ�̬�滮�����ƺ������ܱ�֤���Ž�
		//�������������֣���ʵ�����ж����������أ�
		for(int i=0; i<arr.length; i++) {
			if(i==0) continue;
			for(int j=0; j<=i; j++) {
				if(j==0) {
					arr[i][j] += arr[i-1][j];
					continue;
				}
				if(j==i) {
					arr[i][j] += arr[i-1][j-1];
					continue;
				}
				arr[i][j] += max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		return arr[arr.length-1];
	}

}
