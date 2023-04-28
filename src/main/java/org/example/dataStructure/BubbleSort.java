package org.example.dataStructure;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 2, 5, 1, 6, 8, 9};
        int n = array.length;
        int k = array.length;
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < k ; j++ ) {
                if (i != j && array[i] < array[j]) {
                    int temp = array[i]; //7
                    array[i] = array[j]; //{3,7...}
                    array[j] = temp;
                }
            }
        }
        System.out.print("Sorted array : "+ Arrays.toString(array));
        //Time complexity
        //first for :- 1+n+n=1+2n
        //second for :- 1+n+n+n=1+3n
        //(1+2n)(1+3n)-->1+3n+2n+6n^2-->1+5n+6n^2
        //5n+6n^2-->n(5+6n)-->6n^2
        //O(n^2)-->Quadratic time
    }
}

