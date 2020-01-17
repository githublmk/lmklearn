package com.lmk.modle.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

public class CustomerCollectorAction {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","leng","sfsfsf","aasf");
        Collector<String,List<String>,List<String>> conllector = new ToListConllector<>();
        String[] s=new String[]{"hello","leng","sfsfsf","aasf"};
        List<String> collect = Arrays.stream(s).filter(s1 -> s1.length() > 4).collect(conllector);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
}
