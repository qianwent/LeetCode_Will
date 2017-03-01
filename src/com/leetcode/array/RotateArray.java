package com.leetcode.array;

public class RotateArray {

	public static void main(String[] args) {

		int[] nums = {1,2};//{1,2,3,4,5,6,7}---����1,2������ΪʲôҪȡģ��
		//����n>k�����壬��Ȼ��������array�����ˣ����ǿ���������Ǿ�����Ȼ���Ѿ�����array��������Ȼ��rotate��������Ŀ��û��˵������ô��
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 3);
		for(int i:nums) System.out.println(i);
		
		System.out.println("test %");
		System.out.println(3%7);
		
	}

	public void rotate(int[] nums, int k) {

		if(nums == null || nums.length<2) {
			return;
		}
		
		int mod = k%nums.length;
		
		reverse(nums, 0, nums.length-mod-1);
		reverse(nums, nums.length-mod, nums.length-1);
		reverse(nums, 0, nums.length-1);
		
	}
	
	//һ��ʼ������������temp��������ʱ��ĳ������Ԫ�ص��ڴ�ռ䣬���������index���ã���ȻҪ������
	/*
	 * nums[temp] = nums[start];
			nums[start] = nums[end];
			nums[end] = nums[temp];
			������߼��������temp��index���ã���ônums[temp]�� nums[start]����ͬһ���ڴ������ˣ��Ͳ�����temp�ı������ݵĹ�����
	 */
	public void reverse(int[] nums, int start, int end) {
		int temp = 0;
		while(start<end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
