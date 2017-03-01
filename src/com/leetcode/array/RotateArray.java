package com.leetcode.array;

public class RotateArray {

	public static void main(String[] args) {

		int[] nums = {1,2};//{1,2,3,4,5,6,7}---换成1,2就明白为什么要取模了
		//关于n>k的意义，虽然步数超过array长度了，但是可以想象成是镜像，虽然轴已经超出array，但是依然能rotate过来，题目并没有说不能这么做
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
	
	//一开始犯了致命错误，temp是用来临时存某个数组元素的内存空间，结果当成了index来用，显然要出错了
	/*
	 * nums[temp] = nums[start];
			nums[start] = nums[end];
			nums[end] = nums[temp];
			错误的逻辑，如果把temp当index来用，那么nums[temp]和 nums[start]就是同一个内存区域了，就不存在temp的保存数据的功能了
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
