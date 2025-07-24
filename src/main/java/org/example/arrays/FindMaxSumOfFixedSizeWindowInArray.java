package org.example.arrays;

import java.util.Arrays;

public class FindMaxSumOfFixedSizeWindowInArray {

    public static void main(String[] args) {
//        int[] arr = {3,4,2,7,9,1,3,5,7,8,9,5,6};
        int[] arr = {1,2,3,4,5,6,7,8,9,9,9,9,9};
//        Arrays.sort(arr);
        int windowSize = 3;
        int result=0;
        result =  fixedSizeWindowSum(arr,windowSize);
        System.out.println("Results : "+ result );
    }

    private static int fixedSizeWindowSum(int[] arr, int windowSize) {
        int windowSum =0;
        int result=0;
        if(windowSize > arr.length){
            return 0;
        }
        for (int i = 0; i < windowSize; i++) {
            windowSum+=arr[i];
        }

        result = windowSum;
        for (int readIndex = windowSize; readIndex < arr.length; readIndex++) {
        windowSum = windowSum-arr[readIndex-windowSize]+arr[readIndex];
        result= Math.max(result,windowSum);
        }
        return result;
    }
}


//public static int fixedSizeWindow(int[] arr, int k) {
//    // 1. Handle edge case: Array smaller than window size
//    if (arr.length < k) {
//        return -1; // Or throw an IllegalArgumentException, depending on desired behavior
//    }
//
//    // 2. Initialize variables
//    int windowSum = 0; // Stores the sum of the current window
//    int result = 0;    // Stores the maximum window sum found so far
//
//    // 3. Calculate initial window sum (first 'k' elements)
//    for (int i = 0; i < k; i++) {
//        windowSum += arr[i];
//    }
//    result = windowSum; // The first window's sum is the initial maximum
//
//    // 4. Slide the window through the rest of the array
//    for (int i = k; i < arr.length; i++) {
//        // 5. Update windowSum for the next window
//        // This is the core of the sliding window technique:
//        // - Subtract the element leaving the window (arr[i - k])
//        // - Add the new element entering the window (arr[i])
//        windowSum = windowSum - arr[i - k] + arr[i];
//
//        // 6. Update the overall maximum sum
//        result = Math.max(result, windowSum);
//    }
//
//    // 7. Return the maximum window sum found
//    return result;
//}
