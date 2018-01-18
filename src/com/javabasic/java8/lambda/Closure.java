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
        /*
        注意这里特指local variable
        Any local variable, formal parameter, or exception parameter used but not declared in a lambda expression must
        either be declared final or be effectively final (§4.12.4),
        or a compile-time error occurs where the use is attempted.

        It is worth mentioning that, anonymous classes can access only final local variables (in JAVA SE 7),
        while in Java SE 8 you can access effectively final variables also inside lambda as well as inner classes.
         */
        int i = 0;
//        i = 1;
        Supplier<Integer> supplier = () -> i;
        /*对于Java中闭包的粗浅理解，并不像js中，能够直接函数嵌套函数(注意这是在定义的时候)，
        这是语法设计的时候所不允许的
        这里要注意两种语言的不同，Java是基于类的，类里再定义各种类的属性，方法也是类的属性
        而在js中，function是就是一个variable，这么理解
        https://stackoverflow.com/questions/7295634/javascript-nested-function
        参考这里面的回答
        然后再看这个链接
        http://skilldrick.co.uk/2010/11/a-brief-introduction-to-closures/
        里面的more advanced example，是不是很像Java里面的面向对象了呢？是的，把外层的function看做是类，
        内层的function看做是类的属性，外层所持有的变量就是instance variable，那内部方法就能调用这个成员变量了
        那再回到supplier这个例子，可以这么理解，Java中的闭包，是需要类作为一个wrapper才能支持的
        lambda本身就是一个匿名的实现，本质和anonymous class是一致的，那在Java里这个规则就更复杂了，
        内部类里的方法要调用的外层变量必须是effectively final的，涉及一些更深层次的问题
        详见：https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
        https://www.zhihu.com/question/21395848 还有这里，知乎的解答更能理解一些，但是仍然有点纸上谈兵的意思
        毕竟目前为止实战中用到匿名内部类和lambda中调用外部variable的情况写的还是比较少 TODO
         */

        Closure closure = new Closure();
        closure.r.run();

        closure.s1(closure.s2("a", "b"));

    }

    /*
    再看到这个例子，ii是instance variable，不适用于上面的描述
     */
    int ii=10086;
    Runnable r = () -> {
        seti();
        System.out.print(ii);
    };
    void seti(){
        this.ii++;
    }

    public String s1(String s) {
        return s2(s, "c");
    }

    public String s2(String a, String b) {
        return a + b;
    }

}
