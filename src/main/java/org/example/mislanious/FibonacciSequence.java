package org.example.mislanious;

import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.print("Enter number : ");
        Scanner scan = new Scanner(System.in);
        var input = scan.nextInt();
        printFibonacciSeries(input);
    }

    private static void printFibonacciSeries(int input) {
        int a = 0;
        int b = 1;
        int c = 1;

        System.out.print("Fibonacci Sequence : ");
        for ( int i = 1 ; i < input ; i++ ) {
            System.out.print(a + ", ");
            a = b;
            b = c;
            c = a + b;
        }
    }
}
