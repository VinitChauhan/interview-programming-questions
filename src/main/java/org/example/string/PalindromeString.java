package org.example.string;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.print("Enter string :");
        Scanner scan = new Scanner(System.in);
        var input = scan.nextLine();
        checkPalindrome(input);
    }

    private static void checkPalindrome(String input) {
        List<Character> list = new java.util.ArrayList<>(input.chars().mapToObj(value -> (char) value).toList());
        Collections.reverse(list);
        String reverseString = list.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.print("Reverse String : "+reverseString);
        System.out.print("\nPalindrome String : "+ input.equals(reverseString));
    }
}

