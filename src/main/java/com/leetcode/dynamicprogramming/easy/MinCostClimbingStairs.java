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
     * ���Ȼ���Ҫѧ�ᷢ�ֹ����ԣ�����˼·��Ȼ����Ψһ�ģ��Ͼ���ѧ��������ж��ֽ�
     * ��һ��˼����ʽ��
     * ������¥�ݵķ�ʽ������ʼ�㿪ʼ������ǰһ������������Ҳ����ָ����������ƶ�һ�������
     * Ȼ���ߵ�����һ���ʱ���������ߣ�������ʵ��Ȼ��Ҫô�ƶ�һ���������
     * �������ܿ���һ�������ӽṹ��������������index���ɵģ�prev1, prev2, current
     * Ҫ�ߵ�current����ô��Сcost�޷���prev1������+cost[i]����prev2��һ��+cost[i]
     * ���ﲻҪ����Ծʽ˼ά������ĳ��ֵ����������DP����Ҫ��¼��ÿһ���ġ�����
     * ��󵽱߽��ʱ�򣬾���current֮�������top��Ϊ�Ѿ�����cost������ģ�cost��Ȼ��0
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int prev1 = cost[0], prev2 = cost[1], current = 0;
        for (int i = 2; i < cost.length; i++) {
            /**
             * TODO: �����3����������������������һ�£��ܸо������Ҫ���Լ�ͳһ��������ʽ
             * TODO��Ŀǰ�����������Ե���topΪ������Сcost���Ǵ�top��ǰ����λ��ѡȡ��Сֵ
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
         * һ��ʼ�߽����������ˣ�һ����ʼ�߽�����û���趨�ã�����Ľ����Ȼ���Ǵ����
         * DPȷʵ�Ƿǳ�����ϸ�ڰ�
         */
        total[0] = cost[0];
        total[1] = cost[1];
        for (int i = 2; i < N; i++) {
            /**
             * �Ա�������㷨������û�б䣬������һ��int array��������������int
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
