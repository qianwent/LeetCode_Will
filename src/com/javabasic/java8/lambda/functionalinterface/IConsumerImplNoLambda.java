package com.javabasic.java8.lambda.functionalinterface;

/**
 * Created by Wentao Qian on 2/8/2018.
 *
 * This is still the traditional way to use a interface by overriding the method
 * But with a functional interface, looks like lambda expression is better
 * otherwise the functional interface is useless
 *
 */
public class IConsumerImplNoLambda<T> implements IConsumer<T>{

    public static void main(String[] args) {
        IConsumerImplNoLambda<String> iConsumer = new IConsumerImplNoLambda<>();
        iConsumer.consume("String");
    }

    @Override
    public void consume(T t) {
        System.out.println(t.getClass().getName());
    }
}
