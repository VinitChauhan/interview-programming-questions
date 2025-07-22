package org.example.arrays;

import java.util.Arrays;

public class FindHighestSumOfKElementInArray {

    public static void main(String[] args) {
        int[] arr = {3,4,2,7,9,1,3,5,7,8,9,5,6};
        Arrays.sort(arr);
        int sumWindow = 3;
        int result=0;
        result =  findHigestSum(arr,sumWindow);
        System.out.println("Results : "+ result );
    }

    private static int findHigestSum(int[] arr, int windowSize) {
        int left=0;
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
