package com.javabasic.basic;

/**
 * Created by Wentao Qian on 1/18/2018.
 */
public class BlockScope {

    public static void main(String[] args) {
        //单独挑出来看，是因为在复习JavaScript的时候，再次看到JS没有块级作用域
        //而这似乎是一些脚本语言特有的
        //Java这种强类型语言里，语法相对严谨，块级作用域非常清晰 --- {} 大括号里的就是块级作用域
        if(true) {
            int i = 1;
        }
//        System.out.println(i);
    }

}
