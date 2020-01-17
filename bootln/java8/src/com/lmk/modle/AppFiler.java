package com.lmk.modle;

import com.sun.media.sound.SoftTuning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class AppFiler {

    /**
     * Predicate 接口例子
     * @param appleList
     * @param p
     * @return
     */
    public static List<Apple> findApple(List<Apple> appleList, Predicate<Apple> p){
        List<Apple> alist = new ArrayList<>();
        for(Apple apple: appleList){
            if(p.test(apple)){
                alist.add(apple);
            }
        }
        return alist;
    }

    public static List<Apple> findAppleByWeight(List<Apple> appleList, LongPredicate predicate){
        List<Apple> alist = new ArrayList<>();
        for(Apple apple:appleList){
            if(predicate.test(apple.getWeight())){
                alist.add(apple);
            }
        }
        return alist;
    }

    /**
     * Consumer列子
     * @param list
     * @param consumer
     */
    public static void soutApple(List<Apple> list, Consumer<Apple> consumer){
        for(Apple apple:list){
            consumer.accept(apple);
        }
    }

    /**
     * BiConsumer 可以传两个参数
     * @param list
     * @param c
     * @param consumer
     */
    public static void soutApple(List<Apple> list,String c, BiConsumer<Apple,String> consumer){
        for(Apple apple:list){
            consumer.accept(apple,c);
        }
    }

    /**
     * Funciton 列子
     * @param apple
     * @param function
     * @return
     */
    public static String testFunction(Apple  apple, Function<Apple,String> function){
        return function.apply(apple);
    }

    /**
     * BiFunction
     * @param coler
     * @param weight
     * @param function
     * @return
     */
    public static Apple testBiFunction(String coler,long weight,BiFunction<String,Long,Apple> function){
        return function.apply(coler,weight);
    }

    /**
     * Suplier
     * @param supplier
     * @return
     */
        public static Apple createApple (Supplier<Apple> supplier){
            Apple apple = supplier.get();
            return apple;
        }


    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green",150),
                new Apple("yellow",160),
                new Apple("green",170)
        );
        System.out.println("————predicate——————");
        List<Apple> list = findApple(apples, apple -> "green".equals(apple.getColor()));
        List<Apple> appleByWeight = findAppleByWeight(apples, (long weight) -> {
            return weight > 160l;
        });
        System.out.println(list);
        System.out.println(appleByWeight);

        System.out.println("---- -Consumer-------");
        soutApple(apples,apple -> System.out.println(apple));

        System.out.println("--------BiConsumer----------");
        soutApple(apples,"green",(apple,s) ->{
            System.out.println(apple.getColor()+" is green :"+apple.getColor().equals(s));
        });

        System.out.println("Function--------------------");
        String appleFunction = testFunction(new Apple("green", 100), apple -> apple.toString());
        System.out.println(appleFunction);

        System.out.println("-----------BiFunction----------");
        Apple pink = testBiFunction("pink", 180, (color, weight) -> new Apple(color, weight.intValue()));
        System.out.println(pink);
        System.out.println("Suplier------------------------");
        Apple appleSuplier = createApple(Apple::new);
        System.out.println(appleSuplier);

        System.out.println("--------------------方法推导-----------------");

        BiFunction<String,Integer,Apple> appleBiFunction= Apple::new;;
        Apple func = appleBiFunction.apply("func", 140);
        System.out.println(func);
    }



}
