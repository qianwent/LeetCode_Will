package com.javabasic.basic.polymorphism;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
public abstract class Sedan implements Vehicle {
    @Override
    public void run() {
        System.out.println("Sedan is running");
    }
}
