package org.example.collection.groupBy;

import org.example.model.Contacts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
        Map<String, Integer> collect2 = contactsListSupplier.get().stream().collect(Collectors.groupingBy(Contacts::name, TreeMap::new ,Collectors.summingInt(Contacts::payments)));
        collect2.forEach((name, payment) -> {
            System.out.println(name + "-" + payment);
        });
        System.out.print("\n");

//Group by age
        Map<Integer, List<String>> collect3 = contactsListSupplier.get().stream().collect(Collectors.groupingBy(Contacts::age,TreeMap::new,Collectors.mapping(Contacts::name, Collectors.toList())));
        collect3.forEach((age, name) -> {
            System.out.println(age + "-" + name);
        });
        System.out.print("\n");
    }

}


