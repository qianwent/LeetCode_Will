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

        /*
        TODO: 关于这个invoke方法的参数，见这个链接
        https://www.zhihu.com/question/52551525
        目前看来第一个参数没有什么用。。。那为什么这么设计呢？
        更详细的深入探索：
        http://rejoy.iteye.com/blog/1627405
        //TODO: 同时可以对比一下tiny-spring里面的invoke方法的处理方式，这里的处理方式比较原始
         */

        System.out.println("before invoke...");

        System.out.println("Method:" + method);

        // 从这个invoke方法开始深入探索，就会到NativeMethodAccessorImpl类的native方法，
        // 最终这就是在调用C写的方法，而这恰恰是反射的最根本的技术，光用debug就算debug到底也没用
        // private static native Object invoke0(Method var0, Object var1, Object[] var2);

        //TODO: AOP融入Bean的创建过程
        //https://stackoverflow.com/questions/15447397/spring-aop-whats-the-difference-between-joinpoint-and-pointcut
        method.invoke(subject, args);

        System.out.println("after invoke");

        System.out.println();

        return null;
    }
}
