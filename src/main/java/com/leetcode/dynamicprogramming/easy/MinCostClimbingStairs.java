package com.leetcode.dynamicprogramming.easy;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {

    /**
     * 首先还是要学会发现规律性，而且思路当然不是唯一的，毕竟数学解题可以有多种解
     * 第一种思考方式：
     * 这种走楼梯的方式，从起始点开始，是向前一步或者两步，也就是指针往后可以移动一格或两格
     * 然后走到任意一格的时候，再往后走，发现其实依然是要么移动一格或者两格
     * 这样就能看到一个最优子结构，即三个连续的index构成的，prev1, prev2, current
     * 要走到current，那么最小cost无非是prev1走两步+cost[i]或者prev2走一步+cost[i]
     * 这里不要有跳跃式思维，觉得某个值可以跳过，DP是需要记录下每一步的。。。
     * 最后到边界的时候，就是current之后，那这个top因为已经不在cost数组里的，cost显然是0
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int prev1 = cost[0], prev2 = cost[1], current = 0;
        for (int i = 2; i < cost.length; i++) {
            /**
             * TODO: 这里的3个变量的命名可以再推敲一下，总感觉这个得要有自己统一的命名方式
             * TODO：目前这种命名，以到达top为例，最小cost就是从top的前两个位置选取最小值
             */
            current = cost[i] + Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return Math.min(prev1, prev2);
    }

    public static int minCostClimbingStairs_v2(int[] cost) {
        int N = cost.length;
        if (N == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] total = new int[N];
        /**
         * 一开始边界条件又忘了，一旦初始边界条件没有设定好，后面的结果显然就是错误的
         * DP确实是非常考验细节啊
         */
        total[0] = cost[0];
        total[1] = cost[1];
        for (int i = 2; i < N; i++) {
            /**
             * 对比上面的算法，核心没有变，多用了一个int array，少了两个变量int
             */
            total[i] = cost[i] + Math.min(total[i-1], total[i-2]);
        }

        return Math.min(total[N-1], total[N-2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs_v2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
