package org.example.arrays;

import java.util.*;

public class RemoveDuplicateFromSortedArray {
//    public static void main(String[] args) {
//        int[] arr={1,1,2,2,3,4,5,6,6,6,7,7,8};
//        Set<Integer> set = new TreeSet<>();
//        for(int i=0;i<arr.length;i++){
//            set.add(arr[i]);
//        }
//        ArrayList<Integer> list = new ArrayList<>(set);
//        int[] newArr = list.stream().mapToInt(i -> i).toArray();
//        System.out.println("Array : " + Arrays.toString(newArr));
//    }

//    public static void main(String[] args) {
//        int[] arr={1,1,2,2,3,4,5,6,6,6,7,7,8};
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr.length-1; i++) {
//            set.add(arr[i]);
//        }
//        System.out.println(Arrays.toString(set.toArray()));
//    }

    //with slow pointer
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,5,6,6,6,7,7,8};
        Arrays.sort(arr);
//        int writeIndex = 1;
//        for (int readIndex = 1; readIndex < arr.length ; readIndex++) {
//            if (arr[readIndex]!=arr[readIndex-1]){
//                arr[writeIndex]=arr[readIndex];
//                writeIndex++;
//            }
//        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <arr.length-1 ; i++) {
            list.add(arr[i]);
        }
        Set<Integer> set = new TreeSet<>(list);
       set.stream().forEach(System.out::println);
    }
}
