package com.leetcode.array;

public class BestTimeBuySellStocks {

	public static void main(String[] args) {

		int prices[] = {7, 1, 5, 3, 6, 4};
		int max = maxProfit(prices);
		System.out.println(max);
		
	}
	
	//Kadane's Algorithm
	//最大子串和，经典问题
	//the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
	//TODO 无法处理数组元素全为负数的情况
	public static int maxProfit(int[] prices) {
        
		int maxCurrent = 0, maxSoFar = 0;
		for(int i=1; i<prices.length; i++) {
			maxCurrent = Math.max(0, maxCurrent += prices[i]-prices[i-1]);
			maxSoFar = Math.max(maxCurrent, maxSoFar);
		}
		return maxSoFar;
		
    }

}
