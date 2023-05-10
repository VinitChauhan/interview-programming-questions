package org.example.collection.groupBy;

import org.example.model.Contacts;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        Supplier<List<Contacts>> contactsListSupplier = () -> Arrays.asList(
                new Contacts("Vinit", 39, 400),
                new Contacts("Reema", 35, 500),
                new Contacts("Aarohi", 9, 100),
                new Contacts("Aahana", 5, 200),
                new Contacts("Aarohi", 9, 600),
                new Contacts("Shyam", 39, 500),
                new Contacts("Nirav", 38, 150),
                new Contacts("Jagber", 39, 400),
                new Contacts("Shyam", 39, 100)
        );

//Group by age--> Group by except a single function
        Map<Integer, List<Contacts>> collect = contactsListSupplier.get().stream().collect(Collectors.groupingBy(Contacts::age));
        collect.forEach((age, contacts) -> {
            System.out.println(age + "-" + contacts);
        });
        System.out.print("\n");

//Find Duplicate Name
        List<String> nameList = Arrays.asList("vinit", "reema", "yogesh", "ravi", "vinit", "yogesh", "aarohi");
        Map<String, Long> collect1 = nameList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect1.forEach((name, count) -> {
            System.out.println(name + "-" + count);
        });
        System.out.print("\n");

// Summarise payment by contact name
        Map<String, Integer> collect2 = contactsListSupplier.get().stream().collect(
                Collectors.groupingBy(Contacts::name, TreeMap::new, Collectors.summingInt(Contacts::payments))
        );
        collect2.forEach((name, payment) -> {
            System.out.println(name + "-" + payment);
        });
        System.out.print("\n");

//Group by age
        Map<Integer, List<String>> collect3 = contactsListSupplier.get().stream().collect(
                Collectors.groupingBy(Contacts::age, TreeMap::new, Collectors.mapping(Contacts::name, Collectors.toList()))
        );
        collect3.forEach((age, name) -> {
            System.out.println(age + "-" + name);
        });
        System.out.print("\n");

        Supplier<List<Integer>> listSupplier = () -> Arrays.asList(1, 2, 3, 4, 5, 6);

        //Collect in to list
        listSupplier.get().stream().map(i -> i * 10).toList().forEach(System.out::println);
        System.out.print("\n");

        //Collect into Set
        listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.print("\n");

        // collect into specific type of set
        listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(System.out::println);
        System.out.print("\n");

        //Simple collect into map
        listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.toMap(k -> k * 10, v -> v))
                .forEach((k, v) -> System.out.print(k + " - " + v + "\n"));
        System.out.print("\n");

        //Key Collision
        listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.toMap(k -> k * 10, v -> v, (k1, k2) -> Integer.valueOf(k1 + "-" + k2)))
                .forEach((k, v) -> System.out.print(k + " - " + v + "\n"));
        System.out.print("\n");

        //providing map type
        listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.toMap(k -> k * 10, v -> v, (k1, k2) -> Integer.valueOf(k1 + "-" + k2), TreeMap::new))
                .forEach((k, v) -> System.out.print(k + " - " + v + "\n"));
        System.out.print("\n");

        //Collect and then perform operation
        Integer collect7 = listSupplier.get().stream().map(i -> i * 10)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.print("List Size : " + collect7);
        System.out.print("\n");

        //Find max number from list
        listSupplier.get().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresent(System.out::println);
        System.out.print("\n");

        //Breaking the list in 2 part
        listSupplier.get().stream().collect(Collectors.partitioningBy(integer -> integer > 3))
                .forEach((aBoolean, integers) -> System.out.print(aBoolean + " - " + integers + "\n"));
        System.out.print("\n");

        //Perform operation on min an max element of this list
        System.out.print("\n");
        Integer result = listSupplier.get().stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> min.get()+ max.get()));
        System.out.print("\n"+"Teeing Operation : "+ result);

    }
}


