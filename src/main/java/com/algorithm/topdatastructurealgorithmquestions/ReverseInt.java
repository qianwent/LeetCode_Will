package com.algorithm.topdatastructurealgorithmquestions;

/**
 * Created by Wentao Qian on 12/11/2017.
 */
public class ReverseInt {
    public static void main(String[] args) {
        int origin = 13579;
        int reversed = reverseInt(origin);
        System.out.println(reversed);
    }

    /*
    电话面试中考到了
    modulo is important, need to be more familiar
     */
    private static int reverseInt(int origin) {
        int reversedTemp = 0;
        int originTemp = origin;
        while(originTemp != 0) {
            reversedTemp = reversedTemp*10 + originTemp%10;
            originTemp = originTemp/10;
        }
        return reversedTemp;
    }
}
