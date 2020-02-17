package com.javabasic.java8.lambda.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wentao Qian on 2/8/2018.
 */
public class ICreaterImpl {

    public static void main(String[] args) {
        String[] strings = { "acb", "abc", "cb", "bc" };

        List<String> arrayList = Arrays.asList(strings);
        System.out.println(arrayList.getClass().getName());
        System.out.println(arrayList);

        ICreaterImpl lambdaDemo = new ICreaterImpl();
        List<String> list = lambdaDemo.asList(LinkedList::new, strings);
        System.out.println(list.getClass().getName());
        System.out.println(list);

        ICreater iCreater = () -> new ArrayList<>();
        iCreater.defaultMethod();
    }

    //Arrays.asList() only return ArrayList, so we define a generic method to return whatever list we want
    //based on what lambda we pass in
    private <T> List<T> asList(ICreater<List<T>> creater, T... ts) {
        List<T> list = creater.create();
        for(T t : ts) {
            list.add(t);
        }
        return list;
    }

}
