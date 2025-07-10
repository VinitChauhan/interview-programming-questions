package org.example.arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4, 5 };
        int[] nums2 = { 2, 6 };
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of the two sorted arrays is: " + median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        // Insert remaning numbers
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // formula for Median
        // l = m+n
        // for odd array -- merged[l/2]
        // for even array -- (merged[l/2 -1] + merged[l/2])/2

        double median = 0.0;
        int arrLen = merged.length;
        if (arrLen % 2 == 0) {
            median = (merged[arrLen / 2 - 1] + merged[arrLen / 2]) / 2.0;
        } else {
            median = merged[arrLen / 2];
        }
        return median;
    }
}
