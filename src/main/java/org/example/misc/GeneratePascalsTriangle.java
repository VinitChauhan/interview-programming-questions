package org.example.misc;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = generateTriangle(5);
        triangle.forEach(System.out::println);
    }

    private static List<List<Integer>> generateTriangle(int rows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int i = 1; i < rows; i++) {
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            triangle.add(currentRow);
        }
        return triangle;
    }
}
