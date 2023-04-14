package org.example.mislanious;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {

        System.out.print("Print prime number in range : ");
        Scanner scanner = new Scanner(System.in);
        var limit = scanner.nextInt();
        isPrimeNumber(limit);
    }

    private static void isPrimeNumber(int range) {
        List<Integer> primeNumbers = new ArrayList<>();
        for ( int num = 2 ; num <= range ; num++ ) {
            boolean isPrime = true;
            for ( int fac = 2 ; fac <= num / 2 ; fac++ ) {
                if (num % fac == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(num);
            }
        }
        primeNumbers.forEach(System.out::println);
    }
}
