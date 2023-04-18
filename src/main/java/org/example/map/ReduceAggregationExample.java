package org.example.map;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ReduceAggregationExample {

    public static void main(String[] args) {
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Supplier<IntStream> intStream = () -> IntStream.of(1, 2, 3, 4, 5);
        int results = intStream.get().reduce(0, Integer::sum);
        System.out.println("results = " + results);
        intStream.get().reduce((a, b) -> a * b).ifPresent(System.out::println);
    }
}
