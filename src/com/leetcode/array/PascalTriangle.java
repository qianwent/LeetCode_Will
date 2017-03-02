package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {

		List<List<Integer>> list = generate(6);
		System.out.println(list);
		
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> containerList = new ArrayList<>();
		List<Integer> rowList = new ArrayList<>();
		
		for(int i=0; i<numRows; i++) {
			rowList.add(0,1);
			for(int j=1; j<i; j++) {
				rowList.set(j, rowList.get(j)+rowList.get(j+1));
			}
//			containerList.add(rowList);//这里就不能直接加rowList了，因为这是一个引用，后面对它的操作会改变它的实际值
			//最后变成这样的效果[[1, 5, 10, 10, 5, 1], [1, 5, 10, 10, 5, 1], [1, 5, 10, 10, 5, 1], [1, 5, 10, 10, 5, 1], [1, 5, 10, 10, 5, 1], [1, 5, 10, 10, 5, 1]]
			containerList.add(new ArrayList<>(rowList));
		}
		return containerList;
		
//		List<List<Integer>> containerList = new ArrayList<>();
//		ArrayList<Integer> row = new ArrayList<>();
//		
//		for(int i=0; i<numRows; i++) {
//			row.add(0, 1);
//			for(int j=1;j<row.size()-1;j++)
//				row.set(j, row.get(j)+row.get(j+1));
//			containerList.add(new ArrayList<Integer>(row));
//		}
//		return containerList;
		
	}

}
