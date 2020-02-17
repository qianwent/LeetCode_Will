package com.javabasic.designpatterns;

/**
 * Created by Wentao Qian on 2/7/2018.
 */
public enum EnumSingleton {

    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(1);
        System.out.println(singleton.getValue());
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        System.out.println(singleton1.getValue());
    }

}
