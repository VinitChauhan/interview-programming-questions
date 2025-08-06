package org.example.misc;

public class SquareRoot {
    public static void main(String[] args) {
        int number = 16;
        System.out.println("Square root : " + findSquareRoot(number));
    }

    private static int findSquareRoot(int number) {
        if (number < 2) {
            return number;
        }
        int left = 1;
        int right = number;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if (square == number) {
                return mid;
            } else if (square < number) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
