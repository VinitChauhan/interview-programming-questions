package org.example.arrays;

public class FindLengthOfVariableSizeWindowForTargetValueInAarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 32, 3, 4, 5, 6, 7, 8, 9};
        int target = 8;
//        Arrays.sort(arr);
        int result = lengthOfVariableSizeWindow(arr, target);
        System.out.println("Result : " + result);
    }

    private static int lengthOfVariableSizeWindow(int[] arr, int target) {
        int result = 0;
        int left = 0;
        int windowSum = 0;
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            while (windowSum > target && left <= right) {
                windowSum -= arr[left];
                left++;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
