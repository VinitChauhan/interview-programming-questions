package org.example.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintDistinctCharacterAndCountOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var input = scan.next();
        findDistinctChar(input);
    }
    private static void findDistinctChar(String input) {
        List<Character> list = input.chars().mapToObj(value -> (char) value).toList();
        Map<Character, Integer> map = new HashMap<>();
        for ( Character character : list ) {
            if (map.containsKey(character)) {
                map.replace(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        map.entrySet().forEach(System.out::println);
    }
}
