package org.example.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindRepetedWordFromString {
    public static void main(String[] args) {
        String str = "test,rest";

        Map<String, Integer> collect = Arrays.asList("test", "best", "rest", "sats", "rest", "test", "rest")
                .stream()
                .filter(s -> {
                    String[] split = str.split(",");
                    List<String> list = Arrays.stream(split).toList();
                    return list.contains(s);
                }).collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

        collect.entrySet().forEach(System.out::println);
    }
}
