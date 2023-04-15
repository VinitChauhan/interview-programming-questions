package org.example.mislanious;

import java.util.Scanner;

public class NewCaseStatement {
    public static void main(String[] args) {
        System.out.print("Please insert day of the week : ");
        Scanner scan = new Scanner(System.in);
        var input = scan.next();
        String day = switch (input.toUpperCase()) {
            case "M", "TU", "W" -> "MTUW";
            case "T", "F", "S" -> "TFS";
            default -> {
                if (input.isEmpty()) {
                    yield "Please insert valid Day !";
                } else {
                    yield "looks like Sunday";
                }
            }
        };
        System.out.print("Day : "+day);
    }
}
