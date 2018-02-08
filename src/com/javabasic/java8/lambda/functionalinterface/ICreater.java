package com.javabasic.java8.lambda.functionalinterface;

import java.util.List;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
@FunctionalInterface
public interface ICreater<T extends List<?>> {

    T create();

}
