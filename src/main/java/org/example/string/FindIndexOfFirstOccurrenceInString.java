package org.example.string;

public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {

        String haystack = "sadbutsad", needle = "sad";
//        System.out.println(haystack.contains(needle));
//        int i = haystack.indexOf(needle);
//        System.out.println("i = " + i);
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = true;
            // Inner loop: Compare the substring of haystack with the needle
            for (int j = 0; j < needle.length(); j++) {
                // If a character mismatch is found, set match to false and break the inner loop
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            // If the inner loop completed without a mismatch, we found the first occurrence
            if (match) {
                System.out.println("i = " + i);
            }
        }
    }
}
