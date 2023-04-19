package org.example.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PossiblePairSumForGivenNumberFromArray {
    public static void main(String[] args) {
        System.out.print("Given Array : {1,2,3,4,5,6,7,8,9}\n");
        System.out.print("Enter number for pair search : ");
        Scanner scan = new Scanner(System.in);
        var input = scan.nextInt();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<String> pair = new HashSet<>();
        for ( int i = 0 ; i < array.length ; i++ ) {
            for ( int j = i + 1 ; j < array.length ; j++ ) {
                if (array[i] + array[j] == input) {
                    pair.add(array[i] + "-" + array[j]);
                }
            }
        }
        pair.forEach(System.out::println);
    }
}
