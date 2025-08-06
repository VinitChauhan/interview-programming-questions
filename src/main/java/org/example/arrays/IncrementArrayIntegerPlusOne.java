package org.example.arrays;

import java.util.Arrays;

public class IncrementArrayIntegerPlusOne {
    public static void main(String[] args) {
        int[] arr ={2,4,5};//245+1=246
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            number.append(arr[i]);
        }
        Integer newInt = Integer.valueOf(number.toString())+1;
        String newIntString = newInt.toString();
        char[] charArray = newIntString.toCharArray();

        int[] newArr = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            newArr[i]= Character.getNumericValue(c);
        }
        Arrays.stream(newArr).forEach(System.out::println);
    }
}
