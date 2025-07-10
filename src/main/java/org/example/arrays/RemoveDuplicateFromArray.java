package org.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromArray {

    /**
     * Main method to test the removeDuplicates function.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5 };
        int newLength = removeDuplicates(arr);
        System.out.println("New length of array after removing duplicates: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Removes duplicates from a sorted array.
     *
     * @param arr the sorted array from which duplicates are to be removed
     * @return the new length of the array after removing duplicates
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        // arr =Arrays.stream(arr).distinct().toArray();
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i : arr) {
            uniqueElements.add(i);
        }
        int index = 0;
        for (int j : uniqueElements) {
            arr[index++] = j;
        }
        return uniqueElements.size();
    }
}
