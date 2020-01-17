package com.lmk.modle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2, 3, 4, 5, 6, 7);

        //i是上回计算的结果，j是当前值
        Integer reduce = list.stream().reduce(0, (i, j) -> {
            System.out.println("i:" + i + "|j:" + j);
            return i + j;
        });
        System.out.println(reduce);
        //不传入初始值时，stream的第一个值为初始值，第二个值开始为当前值
        Optional<Integer> reduce1 = list.stream().reduce((i, j) -> {
            System.out.println("i:" + i + "|j:" + j);
            return i + j;
        });
        System.out.println(reduce1.get());
    }
}
