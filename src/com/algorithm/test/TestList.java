package com.algorithm.test;

import java.util.ArrayList;
import java.util.List;

/*
 * �ܽ�list��һЩ����
 */
public class TestList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		System.out.println(list);
		list.add(0,2);//��������index��
		list.add(0,2);//���add��ͬ��index�����ԭ�е��������ƶ�������Ҳ�ܿ�����list��insert��delete������Ч�ʽϵ�
		//��Ϊ���index֮������ж�����Ӧ������ƶ�һλ
		System.out.println(list);
		System.out.println(list.get(2));
		
	}

}
