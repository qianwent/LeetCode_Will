package com.javabasic.basic;

/**
 * Created by Wentao Qian on 12/8/2017.
 */
public class BasicReflection {
    public static void main(String[] args) {
        try {
            //this is the fundamental feature for spring IoC
            Class<?> c = Class.forName("some_class");
            Object oo = c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
