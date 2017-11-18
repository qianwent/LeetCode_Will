package com.javabasic.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wentao Qian on 11/16/2017.
 */
public class ClassMethod {

    String[] array = {"abc", "def", "ghi"};
    List<String> list = Arrays.asList(array);
    //    Arrays.asList(array);//这个是illegal的
    {
        //https://stackoverflow.com/questions/24686721/java-why-cant-i-call-this-method-outside-of-main
        //https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
        //这个比较有趣，以前没有深究过，今天写代码的时候，无意间写错了，忘了把逻辑写在方法或者constructor里面
        //以至于出现了非法语法。
        //事实上根据Oracle的文档，居然还有以下这种写法，可能以前考证的时候看到过。。
    /*
    Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword:

    {
        // whatever code is needed for initialization goes here
    }
    The Java compiler copies initializer blocks into every constructor.
    Therefore, this approach can be used to share a block of code between multiple constructors.
     */
        Arrays.asList(array);
    }

    public void method1() {
        new ArrayList<>();
    }

    public static void main(String[] args) {
        new ArrayList<>();
    }

}
