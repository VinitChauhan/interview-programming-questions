package org.example.list;

import java.util.Arrays;
import java.util.List;

public class CheckAllOddNumberInListInteger {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 13, 5, 17, 7, 10);
        boolean match = list.stream().anyMatch(integer -> integer % 2 == 0);
        System.out.print("List contain all odd integer : " + !match);
    }
}
