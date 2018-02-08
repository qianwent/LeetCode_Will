package com.javabasic.java8.lambda.functionalinterface;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
@FunctionalInterface
public interface IConsumer<T> {

    void consume(T t);

}
