package com.algorithm.test;

import java.util.ArrayList;
import java.util.List;

/*
 * 总结list的一些特性
 */
public class TestList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		System.out.println(list);
		list.add(0,2);//首先是有index的
		list.add(0,2);//其次add相同的index，会把原有的数往后移动，这里也能看出，list在insert和delete操作上效率较低
		//因为会把index之后的所有对象都相应地向后移动一位
		System.out.println(list);
		System.out.println(list.get(2));
		
	}

}
