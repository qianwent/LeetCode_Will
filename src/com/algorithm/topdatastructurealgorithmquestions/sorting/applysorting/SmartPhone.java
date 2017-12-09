package com.algorithm.topdatastructurealgorithmquestions.sorting.applysorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
public class SmartPhone implements Comparable<SmartPhone> {
    private String brand;
    private String model;
    private int price;
    private int rating;

    SmartPhone(String brand,String model,int price, int rating){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.rating = rating;

    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String toString() {
        return"SmartPhone [brand=" + brand + ", model=" + model + ", price=" + price + ", rating=" + rating + "]";
    }

    //这个需要implements Comparable才能有用，需要注意，容易遗忘
    public int compareTo(SmartPhone sp) {
//        return this.price - sp.price;
        if(this.price != sp.price) {
            return this.price - sp.price;
        } else {
            return this.rating - sp.rating;
        }
    }

    public static List<SmartPhone> getSmartPhoneList() {
        List<SmartPhone> phoneList = new ArrayList<>();
        SmartPhone ph1 = new SmartPhone("Apple", "6s", 50000, 10);
        SmartPhone ph2 = new SmartPhone("lg", "pro2", 40000, 9);
        SmartPhone ph3 = new SmartPhone("MI", "3s", 10000, 6);
        SmartPhone ph4 = new SmartPhone("Letv", "le2", 12000, 7);

        phoneList.add(ph1);
        phoneList.add(ph2);
        phoneList.add(ph3);
        phoneList.add(ph4);
        return phoneList;
    }

    public static final Comparator<SmartPhone> smartPhoneComparator = SmartPhone::compareTo;

    public static void main(String[] args) {
        List<SmartPhone> phoneList = getSmartPhoneList();
        System.out.println("Actual List");
        System.out.println(phoneList);

        //sorting using compareTo method
        Collections.sort(phoneList, smartPhoneComparator);
        System.out.println("After sorting");
        System.out.println(phoneList);
    }
}
