package org.example.arrays;

import java.util.Arrays;

public class RemoveArrayElementsMatchwithTargetValue {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int target = 3;
        int[] unmatchArr = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) {
                unmatchArr[index++] = arr[i];
            }
        }
        System.out.println("Array : "+Arrays.toString(unmatchArr));
    }
}
