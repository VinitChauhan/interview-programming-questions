package org.example.arrays;

import java.util.Arrays;

public class AddAllArrayElement {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = {9,8,1, 2, 3, 4, 5};
        for ( int elm : arr ) {
            sum += elm;
        }
        System.out.print("Total Sum :" + sum);

        Arrays.sort(arr);

        //Print Max element of array
        System.out.print("\nMax element: " + Arrays.stream(arr).max().getAsInt());

        //Print second max element of array
        System.out.println("\nSecond Max : "+arr[arr.length - 2]);

        //Print middle element of array
        System.out.println(arr[arr.length / 2]);
    }


}
