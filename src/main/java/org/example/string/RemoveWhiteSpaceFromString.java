package org.example.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveWhiteSpaceFromString {

    public static void main(String[] args) {
        System.out.print("Enter line space separated : ");
        Scanner scan = new Scanner(System.in);
        var input = scan.nextLine();
        removeWhiteSpace(input);
        sortArray();
    }

    private static void sortArray() {
        int[] array={23,3,56,12,-15};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void removeWhiteSpace(String input) {
        String[] split = input.split(" ");
        String collect = Arrays.stream(split).toList().stream().collect(Collectors.joining());
        System.out.print("Space Removed : " + collect);
    }
}
