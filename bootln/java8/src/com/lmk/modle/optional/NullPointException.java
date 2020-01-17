package com.lmk.modle.optional;

public class NullPointException {

    public static void main(String[] args) {


    }
    private static String getInsuranceNameByOptional(Person person){
        return null;
    }

    private static String getInsuranceName(Person person){
        return person.getCar().getInsurance().getName();
    }
}
