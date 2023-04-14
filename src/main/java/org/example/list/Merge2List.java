package org.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge2List {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8,9);

        List<Integer> mergeList = new ArrayList<>(list1);
        mergeList.addAll(list2);
        mergeList.forEach(System.out::println);

    }
}
