package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4,4, 5, 6, 7);
        List<Integer> collect = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(collect);

        String[] words = {"hello","world"};

        Stream<String> stream = Arrays.stream(words);
        Stream<String[]> stream1 = stream.map(w -> w.split(""));

        Stream<String> stringStream = stream1.flatMap(Arrays::stream);
        stringStream.distinct().forEach(System.out::println);



    }
}
