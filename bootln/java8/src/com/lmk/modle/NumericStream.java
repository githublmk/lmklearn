package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer reduce = list.stream().filter(i -> i > 3).reduce(0, Integer::sum);
        System.out.println(reduce);
        int sum = list.stream().mapToInt(i -> i.intValue()).sum();
        System.out.println(sum);
        //boxed()装箱
        List<Integer> collect = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }
}
