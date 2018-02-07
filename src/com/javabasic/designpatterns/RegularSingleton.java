package com.javabasic.designpatterns;

/**
 * Created by Wentao Qian on 2/7/2018.
 */
public class RegularSingleton {

    private static RegularSingleton instance;

    private RegularSingleton() {}

    public static RegularSingleton getInstance() {
        if(instance == null) {
            instance = new RegularSingleton();
        }
        return instance;
    }

}
