package org.example.string;

public class CheckVowelPresenceInString {
    public static void main(String[] args) {
        String str = "Vinit";
        boolean isPresent = stringContainVowel(str);
        System.out.print(isPresent);
    }

    private static boolean stringContainVowel(String str) {
        return str.toLowerCase().matches(".*[aeiou].*");
    }
}
