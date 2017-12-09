package com.javabasic.basic.polymorphism;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
public class AudiSedan extends Sedan {
    @Override
    public void run() {
        System.out.println("Audi Sedan is running");
    }

    public static void main(String[] args) {
        Vehicle car = new AudiSedan();
        //this is to show the basic behavior of polymorphism
        //widely used in Interface-Oriented Programming
        car.run();
    }
}
