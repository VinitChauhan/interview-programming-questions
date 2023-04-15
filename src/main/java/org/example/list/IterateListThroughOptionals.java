package org.example.list;

import java.util.*;

public class IterateListThroughOptionals {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,8,5,1,3);
        Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull).sorted(Integer::compareTo).toList().forEach(System.out::println);
    }
}
