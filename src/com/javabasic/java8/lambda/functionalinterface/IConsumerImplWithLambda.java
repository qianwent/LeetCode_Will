package com.javabasic.java8.lambda.functionalinterface;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
public class IConsumerImplWithLambda {

    public static void main(String[] args) {
        IConsumer<Integer> integerIConsumer = i -> System.out.println(i.getClass().getName());
        integerIConsumer.consume(1);
    }

}
