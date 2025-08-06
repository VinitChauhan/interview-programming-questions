package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 6, 8};
        int[] arr2 = {3, 5, 7, 9, 10};
        ArrayList<Integer> collect1 = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i : arr2) {
            collect1.add(i);
        }
        collect1.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .forEach(System.out::println);
    }
}
