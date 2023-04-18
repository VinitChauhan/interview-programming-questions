package org.example.FunctinalInterface;

import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindEvenOddNumbersFromSequence {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> intStreamSupplier = () -> IntStream.rangeClosed(1, 50).boxed();

        Predicate<Integer> integerEvenPredicate = (n) -> n % 2 == 0;
        Predicate<Integer> integerOddPredicate = (n) -> !(n % 2 == 0);

        Consumer<Integer> integerConsumer = (e)-> System.out.print(e+", ");

        Supplier<Long> longSupplier = ()-> new Random().nextLong();
        Supplier<UUID> uuidSupplier = UUID::randomUUID;

        findEvenNumber(intStreamSupplier.get(), integerEvenPredicate, integerConsumer);

        System.out.print("\n**********************\n");

        findOddNumber(intStreamSupplier.get(), integerOddPredicate,integerConsumer);
    }

    private static <T> void findEvenNumber(Stream<T> integerStream, Predicate<T> integerPredicate, Consumer<T> integerConsumer) {
        integerStream.filter(integerPredicate).forEach(integerConsumer);
    }

    private static <T> void findOddNumber(Stream<T> integerStream, Predicate<T> integerPredicate, Consumer<T> integerConsumer) {
        integerStream.filter(integerPredicate).toList().forEach(integerConsumer);
    }
}
