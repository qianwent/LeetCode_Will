package com.leetcode.array;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
	    if (nums.length==0) return 0;
	    int j=0;
	    for (int i=0; i<nums.length; i++)
	        if (nums[i]!=nums[j]) nums[++j]=nums[i];
	    return ++j;
	}
	
	//从这个算法例子可以看出，即使是题目本身也不是完美的，就像下面的例子，最后arr都没变化，这叫什么算法，那还不如直接找不同的element个数
	//但是题目又硬性要求至少要保证更新后的array最前面的数要没有重复，至于后面是否重复无所谓，所以这种用后面的元素替代前面的算法看起来也算是通用解了
	//总结，算法题实际上只是基础，而越是基础的东西，在实际应用中越不太可能单独出现，所以这些算法题不必深究是不是有意义，特别是加上了一些限定之后
	//做题和实际应用还是有差异的，但是这些题目所涉及到的思想，是很可能应用到实际项目中的，这点值得注意
	public static void main(String[] args) {
		
		int[] arr = {1,2,2,2,2};
		
		int r = removeDuplicates(arr);
		
		System.out.println(r);
		for(int i:arr) {
			System.out.println(i);
		}
		
	}
	
}
