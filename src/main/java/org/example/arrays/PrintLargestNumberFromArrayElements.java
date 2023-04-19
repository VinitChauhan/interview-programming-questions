package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLargestNumberFromArrayElements {
    public static void main(String[] args) {
        Integer[] array = {7, 5553453, 31453, 22, 88534567, 6};
        List<Integer> list = new ArrayList<>(Arrays.stream(array).toList());
        List<Integer> finalList = new ArrayList<>(0);
        List<Integer> tempSplitList = new ArrayList<>(0);
        for ( Integer integer : list ) {
            if (integer > 9) {
                char[] split = integer.toString().toCharArray();
                for ( char c : split ) {
                    tempSplitList.add(Integer.parseInt(Character.toString(c)));
                }
            } else {
                finalList.add(integer);
            }
        }

        finalList.addAll(tempSplitList);
        Collections.sort(finalList);
        Collections.reverse(finalList);
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < finalList.size() ; i++ ) {
            sb.append(finalList.get(i));
        }
        System.out.print("Max Number : "+ sb);

        /*Collections.reverse(list);
        Integer maxNumber = list.stream().findFirst().get();
        int num = Integer.parseInt(Integer.toString(maxNumber).substring(0, 1));
        Integer[] array1 = list.toArray(new Integer[0]);
        int first = array1[0];
        for ( int i = 0 ; i < array1.length - 1 ; i++ ) {
            array1[i] = array1[i + 1];
            if (array1[i] < num) {
                array1[i] = first;
            }
        }
        Arrays.stream(array1).toList().forEach(System.out::println);
        StringBuilder stringBuilder = new StringBuilder(0);
        for ( int i = 0 ; i < array1.length ; i++ ) {
            stringBuilder.append(array1[i]);
        }
        System.out.print("Max Number : " + stringBuilder);*/
    }
}

