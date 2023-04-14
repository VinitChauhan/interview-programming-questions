package org.example.mislanious;

public class Swap2NumbersWithOut3rdNumber {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        a = a + b; //30
        b = a - b; //10
        a = a - b;//20

        System.out.print("a :"+a+ " and "+"b :"+b);
    }
}
