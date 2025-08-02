package org.example.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWordsStartedWithSameChar {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry");
        Map<Character, Long> collect = words.stream().filter(s -> s.length() >= 4).collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        collect.entrySet().forEach(System.out::println);
    }
}
