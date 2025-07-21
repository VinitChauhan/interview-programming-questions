package org.example.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        list.add(triplet);
                    } 
                }
            }
        }
        Set<List<Integer>> setElements = new HashSet<>(list);
        
        for (List<Integer> triplets : setElements) {
            System.out.println("Triplet : " + triplets.toString());
        }
    }
}
