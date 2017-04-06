package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 这算是第一次接触backtracking的高阶用法，代码不复杂，但是要一步一步把状态和输出都写出来，着实花费了点时间
 * 也第一次感受到了机器逻辑和我的逻辑的不同
 * 就这个看似很简单的subset，如果是我手写出来的话，规律也是很简单，那就先罗列单元素的子集，然后两个元素的子集，以此类推，直到写出全集
 * 而这个思路，似乎我的大脑并不用设定什么临时空间来储存一些状态，只是按照一个规律，不涉及计算
 * 但对于程序来说，目前看来很难定义这么一个字面规律让电脑明白，取而代之的是一个算法，按照特定的逻辑，就能生成最终结果，显然人类是不可能这么思考或者推算的
 * 是否从这里也能隐约感觉得出来，人脑和机器逻辑思维的巨大差异，要用算法+海量运算去模拟人的思维，所付出的代价，在我看来这离AI还差得太远
 * 再如大数据，里面肯定涉及AI，但也应该局限在辅助人类处理数据
 * 下围棋的AI，也是基于大数据，从数据中推算最优解，美其名曰深度学习，但要知道围棋是人类发明的，它不同于自然科学，且它所能分析的数据说实话，
 * 只是在目前人类看来是海量数据，
 * 那放到宇宙来说，这点数据太少了，人类对自然科学的理解，和创建出来的理论知识，不是仅仅局限在对数据的处理上，更多的是一种想象和实践的结合
 * 虽说现在有机器学习，但依然只是在人类设定好的规则下，进行分析处理，实际上计算机不知道它在干什么，人类有时候的确狂妄自大，以为现阶段所掌握的知识和技术就能创造出
 * 比大自然沉淀了亿万年的精华更为厉害的东西。看完三体后，更是让我有这样的感想，不能清楚地认识和全面了解自我，最后结果会是怎样。
 * 随笔感想，毕竟人只有匆匆几十年可以奋斗，能通过努力看到越来越多的东西，已然是种幸福，不必苛求太多。
 */
public class Subsets {

	public static void main(String[] args) {
		
		Subsets cs = new Subsets();
		int[] nums = {1,2,3};
		List<List<Integer>> list = cs.subsets(nums);
		System.out.println(list);
		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

}
