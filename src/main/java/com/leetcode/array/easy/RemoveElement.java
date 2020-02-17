package com.leetcode.array.easy;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,2,3,3,2,2,3,2,3};
		int i = removeElement(nums,3);
		System.out.println(i);
		
	}

	//说实话，并不是很清楚这种算法的实际意义，因为这仅仅是把不想删除的往队列最前头挪，而想删除的仍然在队列尾部
	//TODO
	//感觉实际应用中不太会用array来操作，queue应该是常用数据结构，个人猜测，有待考证
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
