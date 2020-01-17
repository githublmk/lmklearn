package com.lmk.modle.collector;

import com.lmk.modle.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CollectorActions2 {
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
        testGroupingByConcurrentWithFunction();
        testGroupingByConcurrentWithFunctionAndCollector();
        testGroupingByConcurrentWithFunctionAndSupplierAndCollector();
        testJoining();
        testJoiningWithDelimiter();
        testJoiningWithDelimiterAndPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }


    private static void testGroupingByConcurrentWithFunction(){
        System.out.println("testGroupingByConcurrentWithFunction");
        ConcurrentMap<Dish.Type, List<Dish>> concurrentMap = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(concurrentMap.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(concurrentMap).ifPresent(System.out::println);

    }

    private static void testGroupingByConcurrentWithFunctionAndCollector(){
        System.out.println("testGroupingByConcurrentWithFunctionAndCollector");
        ConcurrentMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }
    private static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector(){
        System.out.println("testGroupingByConcurrentWithFunctionAndSupplierAndCollector");
        ConcurrentMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    //连接
    private static void testJoining(){
        System.out.println("testJoining");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //连接 带分隔符
    private static void testJoiningWithDelimiter(){
        System.out.println("testJoiningWithDelimiter");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //连接 带分隔符 再在整体的字符串前后加前缀和后缀
    private static void testJoiningWithDelimiterAndPrefixAndSuffix(){
        System.out.println("testJoiningWithDelimiterAndPrefixAndSuffix");
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(",","name[","]"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    //相当于map之后在处理
    private static void testMapping(){
        System.out.println("tstMapping");
        String collect = menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //找最大值
    private static void testMaxBy(){
        System.out.println("testMaxBy");
        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }
    //找最小值
    private static void testMinBy(){
        System.out.println("testMinBy");
        Optional<Dish> collect = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }
}
