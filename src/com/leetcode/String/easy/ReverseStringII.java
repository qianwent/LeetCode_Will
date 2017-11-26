package com.leetcode.String.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        //һ��ʼ����reverse����2��ѡ��Ҫô��Java�Դ���reverse������Ҫô�Լ�дһ��reverse
        //���Աȣ�����reverse��������StringBuilder�ģ��Ƿ������ӻ���
        char[] chars = s.toCharArray();
        int i = 0;
        int n = s.length();//ע�ⲻ�����־�д-1��
        while (i<n) {
            int j = Math.min(i+k-1, n-1);
            swap(chars, i, j);
            i+=2*k;
        }
        return String.valueOf(chars);
    }

    //�����reverseһ������Ķ�ʽ��
    private void swap(char[] chars, int i, int j) {
        while (i<j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }

}
