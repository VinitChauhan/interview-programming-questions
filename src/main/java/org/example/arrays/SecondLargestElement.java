package org.example.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {5,3,8,7,1,9,6};

        int[] array = Arrays.stream(arr).boxed().sorted((o1, o2) -> o2.compareTo(o1)).mapToInt(value -> value).toArray();
        Arrays.stream(array).forEach(System.out::println);

        System.out.println(array[2]);


    }
}
