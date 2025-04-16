package org.example.arrays;

import java.util.Scanner;

public class FindBiggestNumberInArray {
    
    /**
     * Finds the biggest number in an array using a simple loop approach.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param arr The input array
     * @return The biggest number in the array
     */
    public static int findBiggestNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int max = arr[0]; // Initialize max with the first element
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
    }
    
    /**
     * Finds the biggest number in an array using Java's built-in Stream API.
     * 
     * @param arr The input array
     * @return The biggest number in the array
     */
    public static int findBiggestNumberUsingStream(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        return java.util.Arrays.stream(arr).max().getAsInt();
    }
    
    /**
     * Finds the biggest number in an array using Java's built-in Collections.
     * 
     * @param arr The input array
     * @return The biggest number in the array
     */
    public static int findBiggestNumberUsingCollections(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        return java.util.Collections.max(java.util.Arrays.asList(java.util.Arrays.stream(arr).boxed().toArray(Integer[]::new)));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        if (size <= 0) {
            System.out.println("Array size must be positive.");
            scanner.close();
            return;
        }
        
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Find the biggest number using different methods
        int biggestNumber = findBiggestNumber(arr);
        System.out.println("Biggest number (using loop): " + biggestNumber);
        
        int biggestNumberStream = findBiggestNumberUsingStream(arr);
        System.out.println("Biggest number (using Stream): " + biggestNumberStream);
        
        int biggestNumberCollections = findBiggestNumberUsingCollections(arr);
        System.out.println("Biggest number (using Collections): " + biggestNumberCollections);
        
        scanner.close();
    }
} 