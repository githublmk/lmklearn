package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7);

        //allmatch都满足
        boolean allMatch = list.stream().allMatch(i -> i > 10);
        System.out.println(allMatch);

        //anymatch任意一个满足
        boolean anyMatch = list.stream().anyMatch(integer -> integer > 7);
        System.out.println(anyMatch);

        //nonematch都不满足
        boolean noneMatch = list.stream().noneMatch(i -> i < 0);
        System.out.println(noneMatch);
    }
}
