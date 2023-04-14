package org.example.string;

import java.util.Collections;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        reverseString();
    }

    private static void reverseString() {
        String str = "Vinit Chauhan";

        //Using String builder
        StringBuilder sb = new StringBuilder(str);
        System.out.print(sb.reverse().toString());

        //Using streams
        List<Character> charList = new java.util.ArrayList<>(str.chars().mapToObj(c -> (char) c).toList());
        Collections.reverse(charList);
        charList.forEach(System.out::print);
    }
}