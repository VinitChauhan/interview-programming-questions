package org.example.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseArray {


    /**
     * Reverses the given array in place.
     *
     * @param array the array to be reversed
     * @return the reversed array
     */

     public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] reversedArray = reverse(array);
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
        // Output: 5 4 3 2 1
     }

    public static int[] reverse(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int[] revers = Arrays.stream(array)
              .boxed()
              .sorted(Comparator.reverseOrder())    
              .mapToInt(Integer::intValue)
              .toArray();

              System.out.println("Reversed array: " + Arrays.toString(revers));
              
        // int left = 0;
        // int right = array.length - 1;
        
        // while (left < right) {
        //     // Swap elements at left and right indices
        //     int temp = array[left];
        //     array[left] = array[right];
        //     array[right] = temp;
            
        //     // Move towards the middle
        //     left++;
        //     right--;
        // }
        
        return array;
    }
    
}
