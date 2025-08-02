package org.example.string;

public class MinimumWindoowSubstring {
    public static void main(String[] args) {
        String sourceStr = "ADOBECODEBANC";
        String targetStr = "ABC";

        int left = 0;
        StringBuilder window = new StringBuilder();

        for (int right = 0; right < sourceStr.length() ; right++) {
            char currentChar = sourceStr.charAt(right);
            for (int i = 0; i < targetStr.length(); i++) {
                if(targetStr.charAt(i)!=currentChar){
                    

                }
            }
        }
    }
}
