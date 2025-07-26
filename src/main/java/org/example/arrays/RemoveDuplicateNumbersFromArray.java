package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateNumbersFromArray {

    public static void main(String[] args) {
        int[] arr={1,1,2,2,2,2,3,4,5,6,6,7};
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]!=arr[i] && arr[i-1]<arr[i]){
                list.add(arr[i]);
            }
        }
list.forEach(System.out::println);
    }
}
