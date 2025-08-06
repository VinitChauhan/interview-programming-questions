package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReturnIndexOfTargetElement {
    public static void main(String[] args) {
        int[] arr = {5,6,3,8,9,13,4,25};
        Arrays.sort(arr); //{3,4,5,6,8,9,13,25}
        int target = 14;
        ArrayList<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        int i = collect.indexOf(target);
//        System.out.println("i = " + i);
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]>target){
                System.out.println("Insert Position: " + (j-1));
                arr[j]=target;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
