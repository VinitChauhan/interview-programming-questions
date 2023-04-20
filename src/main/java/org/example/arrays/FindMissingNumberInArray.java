package org.example.arrays;

import java.util.Scanner;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        System.out.print("Enter array elements common separated: ");
        Scanner scan = new Scanner(System.in);
        var input = scan.next();
        scan.close();
        String[] split = input.split(",");
        Integer[] intArray = new Integer[split.length];
        Integer sumArray = 0;
        for ( int i = 0 ; i < split.length ; i++ ) {
            intArray[i] = Integer.parseInt(split[i]);
            sumArray += intArray[i];
        }

        int n = intArray.length + 1;
        Integer expSum = (n * (n + 1) )/ 2;

        System.out.print("Missing Number : " + (expSum -sumArray));
    }
}
