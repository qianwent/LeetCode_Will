package com.leetcode.array;

public class BestTimeBuySellStocks {

	public static void main(String[] args) {

		int prices[] = {7, 1, 5, 3, 6, 4};
		int max = maxProfit(prices);
		System.out.println(max);
		
	}
	
	//Kadane's Algorithm
	//����Ӵ��ͣ���������
	//the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
	//TODO �޷���������Ԫ��ȫΪ���������
	public static int maxProfit(int[] prices) {
        
		int maxCurrent = 0, maxSoFar = 0;
		for(int i=1; i<prices.length; i++) {
			maxCurrent = Math.max(0, maxCurrent += prices[i]-prices[i-1]);
			maxSoFar = Math.max(maxCurrent, maxSoFar);
		}
		return maxSoFar;
		
    }

}
