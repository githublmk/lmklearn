package com.lmk.modle.lianxi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        transactions.stream().filter(i -> i.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

        transactions.stream().map(Transaction::getTrader).map(i -> i.getCity()).distinct().forEach(System.out::println);

        transactions.stream().filter(i -> i.getTrader().getCity().equals("Cambridge")).map(i -> i.getTrader()).sorted(Comparator.comparing(Trader::getName)).distinct().forEach(System.out::println);

        transactions.stream().map(i -> i.getTrader().getName()).distinct().sorted().forEach(System.out::println);

        boolean milian = transactions.stream().anyMatch(i -> i.getTrader().getCity().equals("Milan"));
        System.out.println(milian);

        Integer cambridge = transactions.stream().filter(i -> i.getTrader().getCity().equals("Cambridge")).map(i -> i.getValue()).reduce(0, (i, j) -> i + j);
        Integer cambridge1 = transactions.stream().filter(i -> i.getTrader().getCity().equals("Cambridge")).map(i -> i.getValue()).mapToInt(i -> i.intValue()).sum();
        System.out.println(cambridge);
        System.out.println(cambridge1);

        Optional<Integer> first = transactions.stream().sorted(Comparator.comparing(Transaction::getValue).reversed()).map(i -> i.getValue()).findFirst();
        System.out.println(first.get().intValue());
        List<Transaction> transactions1 = transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).limit(1).collect(Collectors.toList());
        System.out.println(transactions1);
    }
}
