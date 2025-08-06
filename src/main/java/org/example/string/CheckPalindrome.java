package org.example.string;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String newStr = str.replace(" ", "").replace(",", "").replace(":", "");
        System.out.println("newStr = " + newStr);
        char[] charArray = newStr.toCharArray();
        StringBuilder strB = new StringBuilder(newStr);
        String reverseStr = strB.reverse().toString();
        System.out.println("Is Palindrome  = " + reverseStr.equalsIgnoreCase(newStr));
    }
}
