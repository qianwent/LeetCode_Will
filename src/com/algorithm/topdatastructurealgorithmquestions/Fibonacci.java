package com.algorithm.topdatastructurealgorithmquestions;

/**
 * Created by Wentao Qian on 12/5/2017.
 */
public class Fibonacci {
    public static void main(String[] args) {
        for(int i=1; i<10; i++) {
            System.out.println(getNthFibonacci(i));
        }
    }

    private static int getNthFibonacci(int i) {
        if(i==1 || i==2) {
            return 1;
        }
        return getNthFibonacci(i-1) + getNthFibonacci(i-2);
    }
}
