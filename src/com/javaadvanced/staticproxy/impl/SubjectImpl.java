package com.javaadvanced.staticproxy.impl;


import com.javaadvanced.staticproxy.Subject;

/**
 * Created by Wentao Qian on 2/25/2018.
 */
public class SubjectImpl implements Subject {
    @Override
    public void method1() {
        System.out.println("method 1");
    }
}
