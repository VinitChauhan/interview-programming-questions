package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String str = "XXIV";
        int value = 0;
        Map<Character, Integer> dic = new HashMap<>();
        dic.put('I', 1);
        dic.put('V', 5);
        dic.put('X', 10);
        dic.put('L', 50);
        dic.put('C', 100);
        dic.put('D', 500);
        dic.put('M', 1000);
        for (int i = 0; i < str.length(); i++) {
            Integer currentValue = dic.get(str.charAt(i));
            if (i + 1 < str.length() && dic.get(str.charAt(i + 1)) > currentValue) {
                value -= currentValue;
            } else {
                value += currentValue;
            }
        }
        System.out.println("Number : " + value);
    }
}
