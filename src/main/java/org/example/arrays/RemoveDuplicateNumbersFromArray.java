package org.example.arrays;

import java.util.*;

public class RemoveDuplicateNumbersFromArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 4, 5, 6, 6, 7};
        Arrays.sort(arr);
//        Set<Integer> set = new TreeSet<>();
//        List<Integer> duplist = new ArrayList<>();
//        for (int i = 0; i < arr.length-1; i++) {
//            if(arr[i]!=arr[i+1] && arr[i]<arr[i+1]){
//                set.add(arr[i]);
//            }else{
//                duplist.add(arr[i]);
//            }
//        }
//
//        set.forEach(System.out::println);
//        System.out.println("\n");
//        duplist.forEach(System.out::println);
//    }

        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                    slow++;
                    arr[slow]=arr[fast];
            }

        }

//        Arrays.stream(arr).boxed().distinct().forEach(System.out::println);
        Arrays.stream(arr).boxed().filter(i->i%2!=0).distinct().forEach(System.out::println);
//        Arrays.stream(arr).boxed().distinct().forEach(System.out::println);

    }
}
