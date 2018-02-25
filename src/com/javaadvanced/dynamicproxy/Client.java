package com.javaadvanced.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Wentao Qian on 2/25/2018.
 */
public class Client {

    public static void main(String[] args) {

        Subject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());

        subject.rent();

        subject.hello("aaa");
    }

}
