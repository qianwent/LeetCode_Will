package com.leetcode.array;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
	    if (nums.length==0) return 0;
	    int j=0;
	    for (int i=0; i<nums.length; i++)
	        if (nums[i]!=nums[j]) nums[++j]=nums[i];
	    return ++j;
	}
	
	//������㷨���ӿ��Կ�������ʹ����Ŀ����Ҳ���������ģ�������������ӣ����arr��û�仯�����ʲô�㷨���ǻ�����ֱ���Ҳ�ͬ��element����
	//������Ŀ��Ӳ��Ҫ������Ҫ��֤���º��array��ǰ�����Ҫû���ظ������ں����Ƿ��ظ�����ν�����������ú����Ԫ�����ǰ����㷨������Ҳ����ͨ�ý���
	//�ܽᣬ�㷨��ʵ����ֻ�ǻ�������Խ�ǻ����Ķ�������ʵ��Ӧ����Խ��̫���ܵ������֣�������Щ�㷨�ⲻ����ǲ��������壬�ر��Ǽ�����һЩ�޶�֮��
	//�����ʵ��Ӧ�û����в���ģ�������Щ��Ŀ���漰����˼�룬�Ǻܿ���Ӧ�õ�ʵ����Ŀ�еģ����ֵ��ע��
	public static void main(String[] args) {
		
		int[] arr = {1,2,2,2,2};
		
		int r = removeDuplicates(arr);
		
		System.out.println(r);
		for(int i:arr) {
			System.out.println(i);
		}
		
	}
	
}
