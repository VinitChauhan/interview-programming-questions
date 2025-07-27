package org.example.arrays;

import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2};
        Arrays.sort(nums);  //{2,3,3,4}

        int val = 3;
//        Arrays.stream(nums).boxed().filter(i -> i != 3).mapToInt(Integer::intValue).forEach(System.out::println);
        for (int i = 0; i < nums.length - 1; i++) {
            int number = nums[i];
            if (number == val && nums[i] != nums[i + 1]) {
                int temp = nums[i];
                nums[i]= nums[i+1];
                nums[i+1] = temp;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
