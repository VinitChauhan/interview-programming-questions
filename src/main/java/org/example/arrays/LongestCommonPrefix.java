package org.example.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs)); // Output: "fl"
//        System.out.println("Longest Common Prefix: " + longestCommonPrefixVerticalScan(strs)); // Output: "fl"
        System.out.println("Longest Common Prefix: " + longestCommonPrefixHorizontalScan(strs)); // Output: "fl"
    }

    private static String longestCommonPrefixHorizontalScan(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    private static String longestCommonPrefixVerticalScan(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int idx = 0;

        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        if (idx > 0) {
            System.out.println("Max possible prefix : " + s1.substring(0, idx));
        } else {
            System.out.println("No matching prefix possible!");
        }
        return s1.substring(0, idx);
    }
}
