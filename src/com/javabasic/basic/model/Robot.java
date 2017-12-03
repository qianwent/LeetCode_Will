package com.javabasic.basic.model;

/**
 * Created by Wentao Qian on 12/3/2017.
 */
public class Robot {
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;

    public Robot() {

    }

    public Robot(String ID) {
        this.ID = ID;
    }
}
