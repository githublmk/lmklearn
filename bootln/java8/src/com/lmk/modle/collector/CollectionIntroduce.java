package com.lmk.modle.collector;

import com.lmk.modle.Apple;


import java.util.*;
import java.util.stream.Collectors;

public class CollectionIntroduce {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("green",150),
                new Apple("yellow",160),
                new Apple("green",170),
                new Apple("green",150),
                new Apple("yellow",160),
                new Apple("green",170)
        );

        List<Apple> green = apples.stream().filter(apple -> apple.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(green).ifPresent(System.out::println);

        Optional.ofNullable(groupByFunction(apples)).ifPresent(System.out::println);
        System.out.println("+++++++++++++++++++++");
        Optional.ofNullable(groupByCollector(apples)).ifPresent(System.out::println);
    }

    private static Map<String,List<Apple>> groupByFunction(List<Apple> appleList){
        Map<String,List<Apple>> map = new HashMap<>();

        appleList.stream().forEach(apple -> {
            Optional.ofNullable(map.get(apple.getColor())).orElseGet(()->{
              List<Apple> list =  new ArrayList<Apple>();
              map.put(apple.getColor(),list);
              return list;
            }).add(apple);

        });
        return map;
    }

    private static Map<String,List<Apple>> groupByCollector(List<Apple> appleList){
        return appleList.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}