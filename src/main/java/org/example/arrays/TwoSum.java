package org.example.arrays;

public class TwoSum {

 

    /**
     * Main method to test the twoSum function.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {


    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] result = twoSum(nums, target);
    System.out.println("Indices of the two numbers that add up to " + target + ": " + result[0] + ", " + result[1]);
    }

    /**
     * Finds two numbers in the array that add up to the target sum.
     *
     * This method uses a hash map to store the indices of the numbers
     * and checks if the complement (target - current number) exists in the map.
     * This approach has a time complexity of O(n).
     *
     * @param nums   the array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers that add up to the target
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i =0; i< nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
    throw new IllegalArgumentException("No two sum solution");
    }
}