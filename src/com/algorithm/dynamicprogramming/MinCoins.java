package com.algorithm.dynamicprogramming;

public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dp();
		
	}

	public static void dp() {
		int a[] = {1,3,5},sum = 11,cent = 0,dp[] = new int[12];
	    dp[0] = 0;//dp表示所需硬币数
	    for(int i = 1; i <= sum; i++) {
	    	dp[i] = i;//我们假设存在1元的硬币那么i元最多只需要i枚1元硬币，当然最好设置dp[i]等于无穷大
	    	//这一步的意义在于，先设定一个最坏情况，毕竟不管什么sum，都可以用n个1元来组合
	    	//那么下面的逻辑就要判断在某一动态规划下，即dp[i]是否大于当减去当前所遍历的这个硬币面值之后的dp值加1，即dp[i - a[j]] + 1
//	    	System.out.println(dp[i]);
	    }
	 
	    //这看起来确实是动态规划，但是总感觉怪怪的，为了得到dp[11]，需要把dp[0]~dp[10]都先遍历出来，然后再求出dp[11]的最优解
	    //这的确和人类的思维不一样，机器需要很强的逻辑来确定一个解，而不像人类用直觉
	    for(int i = 1; i <= sum; i++){
	        for(int j = 0; j < 3; j++){
	            if(i >= a[j] && dp[i - a[j]] + 1 < dp[i]){//主要还是卡在这一步
	                dp[i] = dp[i- a[j] ] + 1;
	                System.out.println("dp[" + i + "] = " + dp[i] + ", one " + a[j] + " + " + "dp[" + (i-a[j]) + "]");
	            }
	        }
	    }
	}
	
}
