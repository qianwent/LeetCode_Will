package com.javaadvanced.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Wentao Qian on 2/25/2018.
 */
public class DynamicProxy implements InvocationHandler {

    //this is the one that we are going to proxy
    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoke...");

        System.out.println("Method:" + method);

        // if the proxy object call the method defined on the real object, this method will be called
        method.invoke(subject, args);

        System.out.println("after invoke");

        System.out.println();

        return null;
    }
}
