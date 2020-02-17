package com.javabasic.basic.initialization;

import com.javabasic.basic.model.Robot;

/**
 * Created by Wentao Qian on 12/3/2017.
 * https://stackoverflow.com/questions/1958636/what-is-double-brace-initialization-in-java
 * http://www.geeksforgeeks.org/anonymous-inner-class-java/
 */
public class DoubleBraceInitialization {
    public static void main(String[] args) {
        //在自己写代码的时候从来没用过这种写法，只在学习的时候看到过anonymous inner class
        //而且是在用接口的时候，为了方便起见，不定义新的class
        /*
        比如这种
        Thread t = new Thread(new Runnable()
        {
            public void run(){System.out.println("Child Thread");}
        });
        t.start();
         */
        //但如果是正常情况下，初始一个类一般用constructor
        Robot robot0 = new Robot("abc");
        //而以下这种写法，则会引起一些潜在问题，具体参考第一个Stack Overflow的答案
        //因为这个会new出anonymous class，可能会造成某些情况下的memory leak，GC，serialising的问题
        Robot robot = new Robot(){{setID("abc");}};

        /*
        结论是最好不要用{{}}，以免引起不必要的麻烦，
        比如memory leak，我估计之前看到的一个项目的memory leak就是因为这种写法造成的，当时是每隔一段时间，可能几天
        内存占用就达到一个高点，必须要重启（当然现在也只能是猜测了，以后碰到类似问题，可以尝试排查这用写法来trouble shooting）
         */
    }
}
