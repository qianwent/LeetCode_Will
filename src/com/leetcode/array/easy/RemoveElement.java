package com.leetcode.array.easy;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,2,3,3,2,2,3,2,3};
		int i = removeElement(nums,3);
		System.out.println(i);
		
	}

	//˵ʵ���������Ǻ���������㷨��ʵ�����壬��Ϊ������ǰѲ���ɾ������������ǰͷŲ������ɾ������Ȼ�ڶ���β��
	//TODO
	//�о�ʵ��Ӧ���в�̫����array��������queueӦ���ǳ������ݽṹ�����˲²⣬�д���֤
	public static int removeElement(int[] nums, int val) {
		
		int j = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}
	
}
