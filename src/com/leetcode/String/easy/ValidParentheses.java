package com.leetcode.String.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    //这个思考了一下，比较难运用正则表达式
    //在看解答，发现居然用的是Stack，第一次知道Stack居然也是一个类。。。
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            //TODO:下面的logic其实非常精妙，以我目前的水准是想不到的 11/26/2017
            //特别是针对这种对称而且要有正确顺序的，stack真的是非常好用的一个数据结构，LIFO
            //栈(stack)与堆(heap)
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
