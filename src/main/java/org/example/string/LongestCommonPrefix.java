package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] sArr = {"flower","flow","flight"};
        Set<Character> set =  new HashSet<>();
        for (int i = 0; i < sArr.length-1; i++) {
            String token = sArr[i];
            for (int j = i+1; j <sArr.length-2 ; j++) {
                Character ci = sArr[i].charAt(token.charAt(i));
                Character cj = sArr[j].charAt(token.charAt(j));
                if(ci.equals(cj)){
                    set.add(ci);
                }

            }

        }
    }



}
