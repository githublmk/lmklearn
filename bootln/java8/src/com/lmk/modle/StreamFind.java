package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFind {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7);

        Optional<Integer> any = list.stream().filter(i -> i % 2 == 0).findAny();
        System.out.println(any.get());
        Optional<Integer> first = list.stream().filter(i -> i % 2 == 0).findFirst();

    }
}
