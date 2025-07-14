package org.example.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindDictionaryWordFromGivenString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Get dictionary words
        System.out.println("Enter dictionary words (space-separated):");
        String dictionaryInput = scan.nextLine().trim();
        
        // Validate dictionary input
        if (dictionaryInput.isEmpty()) {
            System.out.println("Error: Dictionary input cannot be empty.");
            scan.close();
            return;
        }
        
        // Get search string
        System.out.print("Enter string to match words from dictionary: ");
        String searchString = scan.nextLine().trim();
        
        // Validate search string
        if (searchString.isEmpty()) {
            System.out.println("Error: Search string cannot be empty.");
            scan.close();
            return;
        }
        
        scan.close();
        
        // Split dictionary into words
        String[] dictionary = dictionaryInput.split("\\s+");
        // Create a map to store word occurrences
        Map<String, Integer> wordOccurrences = new HashMap<>();
        // Check each dictionary word against the search string
        for (String word : dictionary) {
            // Use word boundary regex to match whole words only
            // (?i) makes the search case-insensitive
            String regex = "(?i)\\b" + Pattern.quote(word) + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(searchString);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            if (count > 0) {
                wordOccurrences.put(word, count);
            }
        }
        
        // Display results
        if (wordOccurrences.isEmpty()) {
            System.out.println("No dictionary words found in the search string.");
        } else {
            System.out.println("Found the following dictionary words in the search string:");
            for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
                System.out.println("Word: \"" + entry.getKey() + "\" - Occurrences: " + entry.getValue());
            }
        }
    }



    //  String  str = "test,rest";
    //    Map<String, Integer> filtered =Arrays.asList("test","best","rest","sats","rest","test","rest").stream()
    //                                 .filter(s->{
    //                                     List<String> tokens = Arrays.asList(str.split(","));
    //                                     return tokens.contains(s);
    //                                 })
    //                                 .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
    //                                 // .collect(Collectors.toList());
    // //    filtered.forEach(System.out::println);
    // filtered.entrySet().forEach(System.out::println);
}
