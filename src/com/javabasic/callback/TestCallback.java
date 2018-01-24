package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class TestCallback {

    public static void main(String[] args) {
        B b = new B();

        A a = new A(b);

        a.call("1+1=?");
    }

}
