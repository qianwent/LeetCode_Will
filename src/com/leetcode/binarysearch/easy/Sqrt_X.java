package com.leetcode.binarysearch.easy;

/**
 * Created by Wentao Qian on 1/8/2018.
 * Implement int sqrt(int x).
 Compute and return the square root of x. x is guaranteed to be a non-negative integer.

 Example 1:
 Input: 4
 Output: 2

 Example 2:
 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842...,
 and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrt_X {

    public int mySqrt(int x) {

        int left = 1, right = x;

        while(left<right) {
            int mid = left + (right - left)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1)) {
                //found solution
                //注意mid<=x/mid，而后面一个条件不能>=，太显然了啊，都+1了，必然>，否则就是endless loop
                return mid;
            } else if(mid>x/mid) {
                right = mid;
            } else {
                left = mid+1;//这里+1的意义在于减少不必要的运算
                //这个就考察一点逻辑了
                //因为能进入到else里面，说明else if statement是不满足的，继而说明mid<=x/mid是满足的
                //所以最后说明只有在不满足(mid+1)>x/(mid+1)的情况下，才会进入最终else判断
                //至此，就比较容易看出left至少要变成mid+1，否则就是把已经缩小的范围再次扩大了
                //一定要注意，这里用二分法，就是把范围一点一点缩小，如果(mid+1)*(mid+1) <= x，那左指针就必须是mid+1
                //这就是算法优化的一些细节，因为如果这里left=mid，也能得到结果，但是速率就下降了
            }
        }
        return left;

    }

}
