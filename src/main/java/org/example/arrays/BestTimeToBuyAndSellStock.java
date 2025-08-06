package org.example.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        ArrayList<Integer> prices = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        Integer lowPrice = prices.stream().min(Integer::compare).get();
        int buyDay = prices.indexOf(lowPrice) + 1;
        System.out.println("Buy Day = " + buyDay);
        int[] newArr = new int[arr.length - 2];
        for (int i = 2; i < arr.length; i++) {
            newArr[i - 2] = arr[i];
        }
        int maxPrice = Arrays.stream(newArr).max().getAsInt();
        int sellDay = prices.indexOf(maxPrice) + 1;
        System.out.println("Sell Day = " + sellDay);
    }
}
