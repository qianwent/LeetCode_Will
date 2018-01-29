package com.javabasic.basic.enumeration;

import java.util.stream.Stream;

/**
 * Created by Wentao Qian on 1/28/2018.
 */
public enum MedicineCode {

    DIAGNOSIS("X357"), MEDICINE_UNIT("X523"),CAUSE_CODE("X536");

    private final String code;

    MedicineCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    public static MedicineCode findByCode(String code) {
        MedicineCode medicineCode = Stream.of(MedicineCode.values()).filter(c->c.code().equals(code)).findFirst().orElse(null);
        return medicineCode;
    }

    public static void main(String[] args) {
        System.out.println(MedicineCode.findByCode("1"));
        System.out.println(MedicineCode.findByCode("X357"));
    }

}
