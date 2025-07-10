package org.example.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
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

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = { "flower", "flow", "flight" };
        System.out.println("Longest Common Prefix: " + lcp.longestCommonPrefix(strs)); // Output: "fl"
    }
}
