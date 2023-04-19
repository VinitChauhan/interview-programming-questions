package org.example.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class HighestNumberFromArray {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        String[] arrStr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrStr[i] = Integer.toString(arr[i]);
        }

        Arrays.sort(arrStr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String leftRight = s1 + s2;
                String rightLeft = s2 + s1;
                return rightLeft.compareTo(leftRight);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arrStr) {
            sb.append(s);
        }

        System.out.println("The highest number is: " + sb.toString());
    }
}
