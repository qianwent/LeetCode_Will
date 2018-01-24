package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class TestCallback {

    /*
    个人理解，这个属于多线程同步
    多线程同步，这个更符合我们日常生活的场景，A和B互相不用等待，按照2个线程，各自执行，最后输出结果
    这个思路是非常好理解的
    但是放到JavaScript里面，就不是这么玩了
    JavaScript是单线程的，注意，不是说单线程就一定是异步的，有阻塞的情况，我们才可能用到异步
     */

    public static void main(String[] args) {
        B b = new B();

        A a = new A(b);

        a.call("1+1=?");
    }

}
