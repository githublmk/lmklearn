package com.lmk.modle.collector;

import com.lmk.modle.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CollectorsAction {

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
        testAveragingDouble();
        testAveragingInt();
        testCollectingAndThen();
        testCounting();
        testGroupingByFunction();
        testGroupingByFunctionAndCollector();
        testGroupingByFunctionAndSupplierAndCollector();
    }

    //求平均值，并转换为Double
    private static void testAveragingDouble(){
        System.out.println("testAveragingDouble");
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //求平均值，并转换为Int 还有long
    private static void testAveragingInt(){
        System.out.println("testAveragingInt");
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //处理之后，在处理
    private static void testCollectingAndThen(){
        System.out.println("testCollectingAndThen");
        String collect = menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), d -> "平均值：" + d));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    //统计个数
    private static void testCounting(){
        System.out.println("testCounting");
        Long collect = menu.stream().collect(Collectors.counting());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    //分组
    private static void testGroupingByFunction(){
        System.out.println("testGroupingByFunction");
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    //分组处理之后在处理
    private static void testGroupingByFunctionAndCollector(){
        System.out.println("testGroupingByFunctionAndCollector");
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndSupplierAndCollector(){
        System.out.println("testGroupingByFunctionAndSupplierAndCollector");
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.counting()));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
}
