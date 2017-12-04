package com.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/*
 * �ܽ�list��һЩ����
 */
public class TestList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(null);
		System.out.println(list);
		list.add(1,2);//��������index��
		list.add(1,2);//���add��ͬ��index�����ԭ�е��������ƶ�������Ҳ�ܿ�����list��insert��delete������Ч�ʽϵ�
		//��Ϊ���index֮������ж�����Ӧ������ƶ�һλ
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println();
		
//		Stream<List<Integer>> stream = Stream.of(list);
//		Stream<Integer> stream2 = stream.map(l->Objects.requireNonNull(l.get(0), "element is null"));
//		stream2.forEach(System.out::print);
		
		
		List<String> list2 = new ArrayList<>();
		list2.add(null);
		list2.add(null);
		Stream<List<String>> stream21 = Stream.of(list2);
		Stream<Obj> stream22 = stream21.filter(s->Objects.nonNull(s)).map(l->new Obj(l.get(0),l.get(1)));
		stream22.forEach(a->System.out.println(a.getA()));

		//array to list
		int[] arr1 = {1,2,3,4,5};
		List<int[]> list1 = Arrays.asList(arr1);//int[] is actually an object, not a primitive.

		//list to array
		List<Integer> integerList = Arrays.asList(1,2,3,4,5);
		Integer[] integers = integerList.toArray(new Integer[integerList.size()]);//���д����Ȼ��֣��������ס
		
	}

}

class Obj {
	private String a;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	private String b;
	public Obj(String a, String b) {
		this.setA(a);
		this.setB(b);
	}
	public Obj() {
		
	}
}
