package org.example.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class CheckArrayContainSameElement {
    public static void main(String[] args) {
        System.out.print("Is Array identical :" + checkArrayElement());
    }

    private static boolean checkArrayElement() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 5};
        Integer[] arr2 = {1, 2, 3, 4, 5, 4, 3, 2, 1};

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
        if (set1.size() != set2.size()) return false;

        for ( Integer elm : set1 ) {
            if (!set2.contains(elm)) return false;
        }
        return true;
    }
}
