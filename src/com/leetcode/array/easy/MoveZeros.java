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
	    	//����㷨ʵ�����ǰѲ���0�ĺ�ǰ������Ĳ���0�����ĺ���һ��0����λ��
	    	//Ҳ����˵����100100�����֣������������ٸ�0�����������ʼ���Ǹ�0��λ���Ǳ�ǹ���
	    	//�ѷ�0���������0λ��һ�������൱�ڰ�0������Ų��
	    	//��Ӧ����һ�ֺܻ����ļ���
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	}
	
	//�Լ���˼·
	public void move0(int[] nums) {
		//��������Ѳ���0�Ķ�copy����һ��array��ȥ������һ�뵽array��ʼ����Ҫ�������ǾͲ����ˣ��б���list
	}
	
}
