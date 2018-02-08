package com.javabasic.java8.lambda.functionalinterface;

import java.util.List;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
@FunctionalInterface
public interface ICreater<T extends List<?>> {

    T create();

    default void defaultMethod() {
        System.out.println("The default method is called.");
    }

    default String defaultStringMethod() {
        return "Functional Interface can have multiple default methods.";
    }

}
