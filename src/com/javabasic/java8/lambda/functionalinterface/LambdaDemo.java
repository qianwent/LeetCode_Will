package com.javabasic.java8.lambda.functionalinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
public class LambdaDemo {

    public static void main(String[] args) {
        String[] strings = { "acb", "abc", "cb", "bc" };
        LambdaDemo lambdaDemo = new LambdaDemo();
        List<String> list = lambdaDemo.testLambda(ArrayList::new, strings);
        System.out.println(list);
    }

    private <T> List<T> testLambda(ICreater<List<T>> creater, T... ts) {
        List<T> list = creater.create();
        for(T t : ts) {
            list.add(t);
        }
        return list;
    }

}
