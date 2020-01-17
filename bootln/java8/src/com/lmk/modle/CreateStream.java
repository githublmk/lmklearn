package com.lmk.modle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 创建stream的几种方式
 */
public class CreateStream {

    private  static  Stream<String> createStreamFromCollection(){
        return Arrays.asList("1","3","5","3").stream();
    }

    private static Stream<String> createStreamFromValues(){
        Stream<String> stringStream = Stream.of("1", "3", "5");
        return stringStream;
    }
    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"1", "3", "5"});

    }

    private static Stream<String> createStreamFromFile(){
        Path path = Paths.get("D:\\代码备份\\bootln\\java8\\src\\com\\lmk\\modle\\CreateStream.java");
        try {
            Stream<String> lines = Files.lines(path);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> stream = Stream.iterate(0, n -> n + 3).limit(10);
        return stream;
    }
    private static Stream<Double> createtStreamFromGenerate(){
        Stream<Double> generate = Stream.generate(Math::random);
        return generate;
    }

    private static Stream<Obj> createObjStreamFromGenerate(){
        Stream<Obj> objStream = Stream.generate(new ObjSupplier()).limit(10);
        return objStream;
    }

    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
        createStreamFromFile().forEach(System.out::println);

        HashMap<String,String> map = new HashMap<>();
        map.put("1","2");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }
    }

    static  class ObjSupplier implements Supplier<Obj>{

        private int index=0;
        private Random random =new Random(System.currentTimeMillis());
        @Override
        public Obj get() {
            index= random.nextInt(100);
            return new Obj(index,"name ->"+index);
        }
    }
    static class Obj{
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
