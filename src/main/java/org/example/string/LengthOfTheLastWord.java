package org.example.string;

public class LengthOfTheLastWord {
    public static void main(String[] args) {
        String str = "Hello World";
        String[] arr = str.split(" ");
        int length = arr.length;
        String lastWord = arr[length-1] ;
        System.out.println("lastWord.length() = " + lastWord.length());
    }
}
