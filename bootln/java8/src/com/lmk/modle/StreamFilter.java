package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4,4, 5, 6, 7);
        Stream<Integer> stream = list.stream();
        List<Integer> collect = stream.filter((Integer i) -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
        collect = collect.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
        collect = collect.stream().limit(2).collect(Collectors.toList());
        System.out.println(collect);
        collect = collect.stream().skip(2).collect(Collectors.toList());
        System.out.println(collect);
    }
}
