package org.example.arrays;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2};
        Arrays.sort(nums);  //{2,3,3,4}

        int val = 3;
//        Arrays.stream(nums).boxed().filter(i -> i != 3).mapToInt(Integer::intValue).forEach(System.out::println);
//        for (int i = 0; i < nums.length - 1; i++) {
//            int number = nums[i];
//            if (number != val && nums[i] != nums[i + 1] && nums[i] >= nums[i + 1] ) {
//                int temp = nums[i];
//                nums[i]= nums[i+1];
//                nums[i+1] = temp;
//            }
//        }
        int[] array = Arrays.stream(nums).filter(value -> value != 3).toArray();

        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=2 && nums[i]!=4){
                collect.add(nums[i]);
            }
        }
        collect.forEach(System.out::println);
    }
}

