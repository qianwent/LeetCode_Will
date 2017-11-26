package com.leetcode.String.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    //���˼����һ�£��Ƚ�������������ʽ
    //�ڿ���𣬷��־�Ȼ�õ���Stack����һ��֪��Stack��ȻҲ��һ���ࡣ����
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            //TODO:�����logic��ʵ�ǳ��������Ŀǰ��ˮ׼���벻���� 11/26/2017
            //�ر���������ֶԳƶ���Ҫ����ȷ˳��ģ�stack����Ƿǳ����õ�һ�����ݽṹ��LIFO
            //ջ(stack)���(heap)
            if(c=='(') {
                stack.push(')');
            } else if(c=='{') {
                stack.push('}');
            } else if(c=='[') {
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop()!=c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]";
        System.out.println(isValid(s));
    }
}
