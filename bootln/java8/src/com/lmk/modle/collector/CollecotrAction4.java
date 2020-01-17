package com.lmk.modle.collector;

import com.lmk.modle.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CollecotrAction4 {
    private static final List<Dish> menu = asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        testSummingDouble();
        testToCollection();
        testToConcurrentMap();
        testToConcurrentMapAndBinaryOperator();

    }

    private static void testSummingDouble(){
        System.out.println("testSummingDouble");
        Double collect = menu.stream().collect(Collectors.summingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);

        //相当于
        Double sum = menu.stream().mapToDouble(Dish::getCalories).sum();
        Optional.ofNullable(sum).ifPresent(System.out::println);
    }

    private static void testToCollection(){
        System.out.println("testToCollection");
        ArrayList<Dish> collect = menu.stream().limit(3).collect(Collectors.toCollection(ArrayList::new));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToConcurrentMap(){
        System.out.println("testToConcurrentMap");
        ConcurrentMap<String, Dish> collect = menu.stream().limit(5).collect(Collectors.toConcurrentMap(Dish::getName, d -> d));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testToConcurrentMapAndBinaryOperator(){
        System.out.println("testToConcurrentMapAndBinaryOperator");
        ConcurrentMap<Dish.Type, Integer> collect = menu.stream().collect(Collectors.toConcurrentMap(Dish::getType, Dish::getCalories, (a, b) -> {
            System.out.println("a:" + a + " b:" + b);
            return a + b;
        }));
        Optional.ofNullable(collect).ifPresent(System.out::println);


    }
}
