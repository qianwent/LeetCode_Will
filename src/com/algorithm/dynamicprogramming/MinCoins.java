package com.algorithm.dynamicprogramming;

public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dp();
		
	}

	public static void dp() {
		int a[] = {1,3,5},sum = 11,cent = 0,dp[] = new int[12];
	    dp[0] = 0;//dp��ʾ����Ӳ����
	    for(int i = 1; i <= sum; i++) {
	    	dp[i] = i;//���Ǽ������1Ԫ��Ӳ����ôiԪ���ֻ��Ҫiö1ԪӲ�ң���Ȼ�������dp[i]���������
	    	//��һ�����������ڣ����趨һ���������Ͼ�����ʲôsum����������n��1Ԫ�����
	    	//��ô������߼���Ҫ�ж���ĳһ��̬�滮�£���dp[i]�Ƿ���ڵ���ȥ��ǰ�����������Ӳ����ֵ֮���dpֵ��1����dp[i - a[j]] + 1
//	    	System.out.println(dp[i]);
	    }
	 
	    //�⿴����ȷʵ�Ƕ�̬�滮�������ܸо��ֵֹģ�Ϊ�˵õ�dp[11]����Ҫ��dp[0]~dp[10]���ȱ���������Ȼ�������dp[11]�����Ž�
	    //���ȷ�������˼ά��һ����������Ҫ��ǿ���߼���ȷ��һ���⣬������������ֱ��
	    for(int i = 1; i <= sum; i++){
	        for(int j = 0; j < 3; j++){
	            if(i >= a[j] && dp[i - a[j]] + 1 < dp[i]){//��Ҫ���ǿ�����һ��
	                dp[i] = dp[i- a[j] ] + 1;
	                System.out.println("dp[" + i + "] = " + dp[i] + ", one " + a[j] + " + " + "dp[" + (i-a[j]) + "]");
	            }
	        }
	    }
	}
	
}
