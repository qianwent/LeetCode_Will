package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * �����ǵ�һ�νӴ�backtracking�ĸ߽��÷������벻���ӣ�����Ҫһ��һ����״̬�������д��������ʵ�����˵�ʱ��
 * Ҳ��һ�θ��ܵ��˻����߼����ҵ��߼��Ĳ�ͬ
 * ��������ƺܼ򵥵�subset�����������д�����Ļ�������Ҳ�Ǻܼ򵥣��Ǿ������е�Ԫ�ص��Ӽ���Ȼ������Ԫ�ص��Ӽ����Դ����ƣ�ֱ��д��ȫ��
 * �����˼·���ƺ��ҵĴ��Բ������趨ʲô��ʱ�ռ�������һЩ״̬��ֻ�ǰ���һ�����ɣ����漰����
 * �����ڳ�����˵��Ŀǰ�������Ѷ�����ôһ����������õ������ף�ȡ����֮����һ���㷨�������ض����߼��������������ս������Ȼ�����ǲ�������ô˼�����������
 * �Ƿ������Ҳ����Լ�о��ó��������Ժͻ����߼�˼ά�ľ޴���죬Ҫ���㷨+��������ȥģ���˵�˼ά���������Ĵ��ۣ����ҿ�������AI�����̫Զ
 * ��������ݣ�����϶��漰AI����ҲӦ�þ����ڸ������ദ������
 * ��Χ���AI��Ҳ�ǻ��ڴ����ݣ����������������Ž⣬������Ի���ѧϰ����Ҫ֪��Χ�������෢���ģ�����ͬ����Ȼ��ѧ���������ܷ���������˵ʵ����
 * ֻ����Ŀǰ���࿴���Ǻ������ݣ�
 * �Ƿŵ�������˵���������̫���ˣ��������Ȼ��ѧ����⣬�ʹ�������������֪ʶ�����ǽ��������ڶ����ݵĴ����ϣ��������һ�������ʵ���Ľ��
 * ��˵�����л���ѧϰ������Ȼֻ���������趨�õĹ����£����з�������ʵ���ϼ������֪�����ڸ�ʲô��������ʱ���ȷ�����Դ���Ϊ�ֽ׶������յ�֪ʶ�ͼ������ܴ����
 * �ȴ���Ȼ������������ľ�����Ϊ�����Ķ�������������󣬸��������������ĸ��룬�����������ʶ��ȫ���˽����ң����������������
 * ��ʸ��룬�Ͼ���ֻ�дҴҼ�ʮ����Էܶ�����ͨ��Ŭ������Խ��Խ��Ķ�������Ȼ�����Ҹ������ؿ���̫�ࡣ
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
