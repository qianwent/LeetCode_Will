package com.leetcode.array.easy;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,0,1};
		MoveZeros mz = new MoveZeros();
		mz.moveZeroes(nums);
		for(int i:nums) System.out.println(i);
		
	}

	public void moveZeroes(int[] nums) {

	    int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	    	//这个算法实际上是把不是0的和前面最近的不是0的数的后面一个0交换位置
	    	//也就是说，如100100，这种，不管跳过多少个0，所跳过的最开始的那个0的位置是标记过的
	    	//把非0的数和这个0位置一换，就相当于把0都往后挪了
	    	//这应该是一种很基础的技巧
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	}
	
	//自己的思路
	public void move0(int[] nums) {
		//本来是想把不是0的都copy到另一个array里去，但是一想到array初始化需要定长，那就不行了，有别于list
	}
	
}
