package com.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,1,2,4,5};
		int m = missingNumber(nums);
		System.out.println(m);
		
		int mm = missingNum(nums);
		System.out.println(mm);
		
		int[] nums2 = {1,2,5,7,9};
		List<Integer> list = missingNumbers(nums2);
		System.out.println(list);
		
		int[] nums_ = {1,3,4,5,0};
		int mm_ = missingNumberG(nums_);
		System.out.println(mm_);
		
	}

	//general solution
	public static int missingNumberG(int[] nums) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		//�����п��٣�ʵ��������Ϊ��Ŀû��˵����[0,1,2]�ǲ������ģ������մ𰸵���˼������ȱ3...����ν�����������ǵ���˼����
		return nums.length*(nums.length+1)/2 - sum;
	}
	
	//����㷨ֻ�����ȱ��һ�����ֵ�array
	public static int missingNumber(int[] nums) {

	    int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}
	
	//�����㷨ֻ�ܶ�����õ�array��Ч������˳��Ͳ�����
	public static int missingNum(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=i) return i;
		}
		return nums.length;
	}
	
	//���miss�Ĳ�ֹһ�������������Ǹ��˵�˼·�����ĸ��ӣ�Ҳ���Լ����ö��ˡ�����
	public static List<Integer> missingNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			if(i==0 && nums[i]!=0) {
				list.add(0);
				continue;
			}
			if((nums[i]-nums[i-1])!=1) {
				for(int j=0; j<(nums[i]-nums[i-1])-1; j++) {
					list.add(nums[i-1]+1+j);
				}
			}
		}
		return list;
	}
	
}
