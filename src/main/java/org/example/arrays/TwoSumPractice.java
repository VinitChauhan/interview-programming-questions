package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumPractice {

    public static void main(String[] args) {
          int[] nums = {2,3,5,7,6,4,8,9,10,14,16,18};
          int target = 10;
          Arrays.sort(nums);
          ArrayList<int[]> findPair = findPairFromArray(nums, target);
          for(int[] elements:findPair){
              System.out.println(Arrays.toString(elements));
          }
    }

    private static ArrayList<int[]> findPairFromArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        ArrayList<int[]> pairs = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                pairs.add(new int[]{nums[left], nums[right]});
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
}
