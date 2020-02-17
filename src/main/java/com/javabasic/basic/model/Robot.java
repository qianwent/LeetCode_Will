package com.javabasic.basic.model;

/**
 * Created by Wentao Qian on 12/3/2017.
 */
public class Robot {
    private String ID;

    private String type;

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Robot() {

    }

    public Robot(String ID) {
        this.ID = ID;
    }

    public Robot(String ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public void reportID() {
        System.out.println("My ID is: " + ID);
    }

    public String generateRobotName() {
        return "Robot-"+ID;
    }
}
