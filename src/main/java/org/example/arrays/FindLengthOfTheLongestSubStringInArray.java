package org.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindLengthOfTheLongestSubStringInArray {
    public static void main(String[] args) {
        String[] arr = {"abcdefabcdf","dsaddsa","sdsadasf"};
        for (String s:arr) {
            int maxLength = findLengthOfTheLongestSubStringInArray(s);
            System.out.println("MaxLength : "+maxLength);
        }
    }

    private static int findLengthOfTheLongestSubStringInArray(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right=0; right<s.length();right++){
            char currentChar = s.charAt(right);
            while(set.contains(currentChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}


//MaxLength : 6
//MaxLength : 3
//MaxLength : 4