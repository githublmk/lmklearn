package com.lmk.modle.optional;

import java.util.Optional;

public class OptionalInAction {

    public static void main(String[] args) {
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);
    }

    private static String getInsuranceNameByOptional(Person person){
      return   Optional.ofNullable(person)
                .map(person1 -> person1.getCar())
                .map(Car::getInsurance)
                .map(Insurance::getName).orElse("no zhi");
    }
}
