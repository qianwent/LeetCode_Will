package com.javaadvanced.dynamicproxy.impl;

import com.javaadvanced.dynamicproxy.Subject;

/**
 * Created by Wentao Qian on 2/25/2018.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
