package com.leetcode.dynamicprogramming.medium;

/**
 * n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat
 * randomly. But after that, the rest of passengers will:
 *
 * Take their own seat if it is still available,
 * Pick other seats randomly when they find their seat occupied
 * What is the probability that the n-th person can get his own seat?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 1.00000
 * Explanation: The first person can only get the first seat.
 * Example 2:
 *
 * Input: n = 2
 * Output: 0.50000
 * Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 */
public class AirplaneSeatAssignmentProbability {

    public static double nthPersonGetsNthSeat(int n) {
        /**
         * 最简单的理解方式：
         * f(n)分3种情况
         * 1. p1选了1，这个是1/n的概率，对于pn来说就是100%能坐到自己的座位
         * 2. p1选了n，依然是1/n的概率，对于pn来说就是0%能坐到自己的位置
         * 3. p1选了2-n-1任意一个，每一个都是1/n的概率，对于pn来说，每一种都有50%的概率坐到自己的位置
         * 这里不用考虑很复杂，因为题意没有说后面的人员是按什么顺序入座，
         * 完全可以理解为，除了被占座的人，和占座人本身，其余所有人都可以按号入座
         * 这样的话，f(n)=(1/n)*1+(1/n)*0+((n-2)/2)*0.5
         * 但是这样就看不出是一个递归类型了，因为已经得出n>1的时候，概率都是0.5了
         * 更正一下就是f(n)=1/n+f(n-1)/n+f(n-2)/n+...+f(2)/n
         * 为什么就能用f(n-1)等等递归呢？一开始没想明白，觉得不能再等式右边套用f(n-1)
         * https://leetcode.com/problems/airplane-seat-assignment-probability/discuss/414864/True-formula-and-explanations-for-all-other-formulas.
         * 看过这里的完整解释之后，才明白f(n-1)是sub problem，即当p1选2nd座位之后，剩下了n-1个座位，对于p2来说，就和p1一开始碰到的问题就一致了，
         * p1是从n个座位里随机选，p2是从n-1个座位里随机选，以此类推，p(n-1)就是从2个座位里随机选
         */
        if (n == 1) {
            return 1d;
        } else {
            return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(7));
    }
}
