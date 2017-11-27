package com.leetcode.String.easy;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:
 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
 "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 Example 2:
 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 Note:

 s.length will be between 1 and 50,000.
 s will only consist of "0" or "1" characters.
 */
public class CountBinarySubstrings {

    /*
    ����������Ŀ��һ��ʼ��û��˼·�ģ�������������ôһ�ָо������һ���㷨��Ҫ�������������Ӽ�����
    ����˵�������ƺ�Ҫ����һЩ��ѧ����ģ���ô����ȴ�sample����ȡһЩ���ɣ��ѹ�����ת����code
    ͬʱ���ֹ���Ҳ���԰����ж��Ƿ���������
    ���磺s = "110001111000000"�� ������groups = [2, 3, 4, 6]
    ��ô���������ľ�������'0' * k + '1' * k or '1' * k + '0' * k��binary string
    �Ӽ���Ȼ����[2,3], [3,4], [4,6]
    ÿ���Ӽ�������������substring��������С���Ǹ���
     */
    public static int countBinarySubstrings(String s) {
        int[] arr = new int[s.length()];
        int count = 0;
        arr[count] = 1;
        int prev = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == prev) {
                arr[count]++;
            } else {
                prev = s.charAt(i);
                count++;
                arr[count]++;
//                arr[count++]++;//��ôдcount��û������arr[count]++�ˣ���Ȼ����
            }
        }
        int subStringCount = 0;
        /*
        TODO:����ע��һ��s.length()������s.length()-1
        Ϊʲô�����ǳ�����������ĵ�һ�о��������������Ϊÿ��ȥ��֤�����е��˷�ʱ���ˣ���Ӧ���ǿ����γɼ�������
        ��for loop�У�����߽�������ҪС��string���ܳ��ȵģ�-1��Ȼ������
        ��ôʲôʱ����õ�-1��ĿǰΪֹ���õý϶����������ָ��бƵ�ʱ����ָ���index��s.length()-1
        ע�⣺���������������Ƿǳ����Եģ�
         */
        for(int i=1; i<s.length(); i++) {
            subStringCount += Math.min(arr[i-1], arr[i]);
        }
        return subStringCount;
    }

    public static void main(String[] args) {
        int count = countBinarySubstrings("00110");
        System.out.println(count);
    }

}
