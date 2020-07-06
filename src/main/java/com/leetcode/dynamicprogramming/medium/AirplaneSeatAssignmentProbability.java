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
         * ��򵥵���ⷽʽ��
         * f(n)��3�����
         * 1. p1ѡ��1�������1/n�ĸ��ʣ�����pn��˵����100%�������Լ�����λ
         * 2. p1ѡ��n����Ȼ��1/n�ĸ��ʣ�����pn��˵����0%�������Լ���λ��
         * 3. p1ѡ��2-n-1����һ����ÿһ������1/n�ĸ��ʣ�����pn��˵��ÿһ�ֶ���50%�ĸ��������Լ���λ��
         * ���ﲻ�ÿ��Ǻܸ��ӣ���Ϊ����û��˵�������Ա�ǰ�ʲô˳��������
         * ��ȫ�������Ϊ�����˱�ռ�����ˣ���ռ���˱������������˶����԰�������
         * �����Ļ���f(n)=(1/n)*1+(1/n)*0+((n-2)/2)*0.5
         * ���������Ϳ�������һ���ݹ������ˣ���Ϊ�Ѿ��ó�n>1��ʱ�򣬸��ʶ���0.5��
         * ����һ�¾���f(n)=1/n+f(n-1)/n+f(n-2)/n+...+f(2)/n
         * Ϊʲô������f(n-1)�ȵȵݹ��أ�һ��ʼû�����ף����ò����ٵ�ʽ�ұ�����f(n-1)
         * https://leetcode.com/problems/airplane-seat-assignment-probability/discuss/414864/True-formula-and-explanations-for-all-other-formulas.
         * �����������������֮�󣬲�����f(n-1)��sub problem������p1ѡ2nd��λ֮��ʣ����n-1����λ������p2��˵���ͺ�p1һ��ʼ�����������һ���ˣ�
         * p1�Ǵ�n����λ�����ѡ��p2�Ǵ�n-1����λ�����ѡ���Դ����ƣ�p(n-1)���Ǵ�2����λ�����ѡ
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
