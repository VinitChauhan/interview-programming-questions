package org.example.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    
    public static void main(String[] args) {
        String str = "test,rest";

        Map<String, Integer> filtered = Arrays.asList("test", "best", "rest", "sats", "rest", "test", "rest").stream()
                .filter(s -> {
                    String[] str_1 = str.split(",");
                    List<String> tokens = Arrays.asList(str_1);
                    return tokens.contains(s);
                })
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
        // .collect(Collectors.toList());
        //    filtered.forEach(System.out::println);
        filtered.entrySet().forEach(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry");
        Map<Character, Long> collect = words.stream().filter(w -> w.length() >= 4).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
        for (Map.Entry<Character, Long> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
