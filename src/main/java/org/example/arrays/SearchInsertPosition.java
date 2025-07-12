package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        int target = 3;
        int position = searchInsert(arr, target);
        System.out.println("Target " + target + " should be inserted at index: " + position);
    }

    public static int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> position = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                position.add(i);
            }
        }
        int spot = position.size()==0?(nums.length)+1:position.get(0);
        return spot;
    }
}
