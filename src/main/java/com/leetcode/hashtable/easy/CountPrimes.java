package com.leetcode.hashtable.easy;

/**
 * Description:

 Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

    //第一次实战质数问题，原来有这种巧妙的解法
    public int countPrimes(int n) {
        boolean[] nonPrime = new boolean[n];//by default, all the values should be false after initialization
        int count = 0;
        for(int i=2; i<n; i++) {
            if(nonPrime[i] == false) {
                count++;
                for(int j=2; i*j<n; j++) {
                    nonPrime[i*j] = true;
                }
            }
        }
        return count;
    }

}
