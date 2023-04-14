package org.example.string;

import java.util.*;

public class PrintRepeatedWordsFromString {
    public static void main(String[] args) {
        System.out.print("Enter line with repeated words : ");
        Scanner scan = new Scanner(System.in);
        var input = scan.nextLine();
        printedRepeatedWords(input);
    }

    private static void printedRepeatedWords(String input) {
        List<String> list = Arrays.stream(input.split(" ")).toList();
        Map<String, Integer> map = new HashMap<>();
        for ( String s : list ) {
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        map.entrySet().forEach(System.out::println);
    }
}
