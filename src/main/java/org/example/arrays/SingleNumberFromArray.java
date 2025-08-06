package org.example.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumberFromArray {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        for (Map.Entry<Integer, Long> entry:collect.entrySet()){
            if(entry.getValue()==1){
                System.out.println("Single Number = " + entry.getKey());
            }
        }
    }
}
