package org.example.arrays;

public class CheckPalindromeNumber {

    public static void main(String[] args) {
        int number = 12211;
        String numStr = Integer.toString(number);
        StringBuilder sb =  new StringBuilder(numStr);
        sb.reverse();
        if(numStr.equals(sb.toString())){
            System.out.println("Is Pelindrome : "+true );
        }else{
            System.out.println("Is Pelindrome : "+false);
        }
    }
}