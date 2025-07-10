package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,5,6,6,6,7,7,8};
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        int[] newArr = list.stream().mapToInt(i -> i).toArray();
        System.out.println("Array : " + Arrays.toString(newArr));
    }
}
