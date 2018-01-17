package com.javabasic.java8.lambda;

import java.util.function.Supplier;

/**
 * Created by Wentao Qian on 1/17/2018.
 * 对Java中闭包的思考是源自复习JavaScript中的闭包，因为想弄清楚闭包到底有什么作用，为什么Java写了这么久
 * 却似乎没有这个概念，到底是忽略了，还是真的没有，需要一探究竟
 * https://www.zhihu.com/question/63548795
 * 这个知乎问题里有一些代码，拿下来试一下，发现引申出来的问题有点复杂。。。
 */
public class Closure {

    public static void main(String[] args) {
        int i = 0;
//        i = 1;
        Supplier<Integer> supplier = () -> i;

        Closure closure = new Closure();
        closure.r.run();

    }

    int ii=10086;
    Runnable r = () -> {
        seti();
        System.out.print(ii);
    };
    void seti(){
        this.ii++;
    }

}
