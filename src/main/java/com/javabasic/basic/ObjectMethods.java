package com.javabasic.basic;

/**
 * Created by Wentao Qian on 12/8/2017.
 */
public class ObjectMethods {
    public static void main(String[] args) {
        Object o = new Object();
        o.equals(o);
        o.hashCode();
        o.toString();
        o.getClass();
        o.notify();
        o.notifyAll();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
