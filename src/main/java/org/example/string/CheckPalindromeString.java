package org.example.string;

import java.util.Arrays;
import java.util.Collections;


public class CheckPalindromeString {

    public static void main(String[] args) {
        String str = "12abcdcba21";
        char[] cArr = str.toCharArray();
       boolean isPalindrome1= checkPalindromeWithArray(cArr);
       boolean isPalindrome2= checkPalindromeWithOutArray(str);
        System.out.println("isPalindrome 1 : "+ isPalindrome1);
        System.out.println("isPalindrome 2 : "+ isPalindrome2);
    }

    private static boolean checkPalindromeWithOutArray(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            if(left<right && !Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }
            if(left<right && !Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if(Character.isDigit(str.charAt(left))!=Character.isDigit(str.charAt(right))){
                return false;
            }
            if(Character.isLetter(str.charAt(left))!=Character.isLetter(str.charAt(right))){
                return false;
            }
            else {
                left++;right--;
            }
        }
        return true;
    }

    private static boolean checkPalindromeWithArray(char[] cArr){
        int left = 0;
        int right = cArr.length-1;
        while (left<right){
            if(!Character.isLetterOrDigit(cArr[left])){
                left++;
            }
            if(!Character.isLetterOrDigit(cArr[right])){
                right--;
            }
            if(cArr[left] == cArr[right]){
                left++;right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
