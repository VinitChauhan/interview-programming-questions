package org.example.function;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateExamples {
    public static void main(String[] args) {

        System.out.print("Insert string for checking vowel : ");

        Scanner scan = new Scanner(System.in);
        var input = scan.next();

        Predicate<String> checkVowelPredicate = (s) -> s.matches(".*[aioue].*");
        System.out.println("CheckVowelPredicate = " + checkVowelPredicate.test(input));

    }


}
