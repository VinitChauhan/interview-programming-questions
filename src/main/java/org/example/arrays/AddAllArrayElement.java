package org.example.arrays;

import java.util.Arrays;

/**
 * A utility class that demonstrates various array operations including:
 * - Calculating the sum of all elements in an array
 * - Finding the maximum element
 * - Finding the second maximum element
 * - Finding the middle element
 * 
 * This class provides a simple implementation of common array operations
 * using both traditional loops and Java Stream API.
 *
 * @author org.example
 * @version 1.0
 */
public class AddAllArrayElement {
    
    /**
     * Main method that demonstrates various array operations.
     * 
     * The method performs the following operations:
     * 1. Calculates the sum of all elements in the array
     * 2. Sorts the array in ascending order
     * 3. Finds and prints the maximum element using Stream API
     * 4. Finds and prints the second maximum element
     * 5. Finds and prints the middle element of the array
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {9,8,1, 2, 3, 4, 5};
        
        // Calculate sum of all elements
        for ( int elm : arr ) {
            sum += elm;
        }
        System.out.print("Total Sum :" + sum);

        // Sort array in ascending order
        Arrays.sort(arr);

        //Print Max element of array
        System.out.print("\nMax element: " + Arrays.stream(arr).max().getAsInt());

        //Print second max element of array
        System.out.println("\nSecond Max : "+arr[arr.length - 2]);

        //Print middle element of array
        System.out.println(arr[arr.length / 2]);
    }
}
