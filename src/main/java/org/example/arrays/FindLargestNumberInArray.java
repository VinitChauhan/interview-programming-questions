package org.example.arrays;

import java.util.Arrays;

public class FindLargestNumberInArray {

    public static void main(String[] args) {
        int[] arr = {21,212,1,545,656,2,34,45,56,65};

        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);

    }



}
