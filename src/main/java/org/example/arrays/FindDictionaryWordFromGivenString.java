package org.example.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDictionaryWordFromGivenString {
    public static void main(String[] args) {
        System.out.println("Enter dictionary words :");
        Scanner scan = new Scanner(System.in);
        var dictionaryInput = scan.nextLine();
        System.out.print("Enter string to match word from dictionary : ");
        var searchString = scan.nextLine();
        scan.close();
        String[] dictionary = dictionaryInput.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for ( String s : dictionary ) {
            if (searchString.contains(s)) {
                if (map.containsKey(s)) {
                    map.replace(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        map.entrySet().forEach(System.out::println);
    }
}
