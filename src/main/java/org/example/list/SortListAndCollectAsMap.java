package org.example.list;

import java.util.*;
import java.util.stream.Collectors;

public class SortListAndCollectAsMap {

    public record User(Integer id, String name, Integer age) {
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(4, "vinit", 39));
        list.add(new User(1, "aahana", 5));
        list.add(new User(2, "aarohi", 9));
        list.add(new User(3, "reema", 32));

        Map<String, Integer> collect = list.stream().sorted(Comparator.comparingLong(User::age))
                .collect(Collectors.toMap(User::name, User::age, (old, latest) -> old, LinkedHashMap::new));
        collect.entrySet().forEach(System.out::println);

    }
}
