package com.lmk.modle.collector;

import com.lmk.modle.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CollectorAction3 {
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
        testPartitioningByWithPredicate();
        testPartitioningByWithPredicateAndCollector();
        testReducingBinaryOperator();
        testReducingBinaryOperatorAndIdentity();
        testReducingBinaryOperatorAndIdentityAndFunction();
        testSummarizingInt();
    }

    //分组，只有true和false两组
    private static void testPartitioningByWithPredicate(){
        System.out.println("testPartitioningByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVagetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testPartitioningByWithPredicateAndCollector(){
        System.out.println("testPartitioningByWithPredicateAndCollector");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVagetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperator(){
        System.out.println("testReducingBinaryOperator");
        Optional<Dish> collect = menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories))));
        collect.ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentity(){
        System.out.println("testReducingBinaryOperatorAndIdentity");
        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testReducingBinaryOperatorAndIdentityAndFunction(){
        System.out.println("testReducingBinaryOperatorAndIdentityAndFunction");
        Integer collect = menu.stream().collect(Collectors.reducing(0,Dish::getCalories ,(d1, d2) -> d1 + d2));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //平均数，最大值，最小值，数量
    private static void testSummarizingInt(){
        System.out.println("testSummarizingInt");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
}
