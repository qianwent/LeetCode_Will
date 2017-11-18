package com.javabasic.java8.lambda;

import com.javabasic.basic.util.*;
import com.javabasic.basic.util.Timer;

import java.util.*;

/**
 * Created by Wentao Qian on 11/16/2017.
 */
public class BasicLambda {

    /*
        definition of lambda: anonymous function which we only care about the logic or computation
     */
    public static void main(String[] args) throws InterruptedException {
        //#1
        compareTraversalOnly();
        testTimer();

    }

    //#1
    public static void compareTraversalOnly() {
        List<Map<String, Object>> list = new ArrayList<>();
        for(int i=0; i<100000; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("title", "title"+i);
            map.put("view", "view"+i);
            list.add(map);
        }
        streamTraverse(list);
        forLoopTraverse(list);
    }

    @Timer
    private static void streamTraverse(List<Map<String, Object>> list) {
        list.stream().forEach(p -> System.out.print(p.get("id")+" "+p.get("title")));
    }

    @Timer
    private static void forLoopTraverse(List<Map<String, Object>> list) {
        for(Map map:list){
            System.out.print(map.get("id")+" "+map.get("title"));
        }
    }

    @Timer
    public static void testTimer() throws InterruptedException {
        Thread.sleep(2000);
    }

}
