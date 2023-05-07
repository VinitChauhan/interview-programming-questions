package org.example.dataStructure;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 8, 2, 0, 34, 23, 90};
        insertionSort(array);
    }

    private static void insertionSort(int[] array) {
        for ( int i = 1 ; i < array.length ; i++ ) {
            int current = array[i];
            int j = i - 1;
            System.out.print("\ni = " + i + " j = " + j + " --> " + Arrays.toString(array));
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
            System.out.print(" --> " + Arrays.toString(array));
        }
        System.out.print("\n" + Arrays.toString(array));
    }
}
