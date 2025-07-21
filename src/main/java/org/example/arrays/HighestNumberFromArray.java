package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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



//        int[] arr= {3,5,34,56,87,2,9};
//
//        List<Integer> list = new ArrayList<>(arr.length);
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>=10){
//                list.add(arr[i]/10);
//                list.add(arr[i]%10);
//            }else {
//                list.add(arr[i]);
//            }
//        }
//        list.sort((o1, o2) -> o2.compareTo(o1));
//        StringBuilder result = new StringBuilder();
//        for(int k : list){
//            result.append(k);
//        }
//        System.out.println(result);
    }
}
