package org.example.arrays;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArrayElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        Random random = new Random();

        for ( int elm = 0 ; elm < arr.length ; elm++ ) {
            int randomIndex = random.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[elm];
            arr[elm] = temp;
        }
        System.out.print("Shuffle Array : "+ Arrays.toString(arr));
    }
}
