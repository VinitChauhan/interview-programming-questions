package org.example.dataStructure;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 6, 4, 5, 2, 4, 7};
//        System.out.print("Enter common separated array elements : ");//{1,,2,3,4,5,6,7,8,9}
//        Scanner scan = new Scanner(System.in);
//        var input = scan.next();
//        List<Integer> list = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
//        Integer[] array = new Integer[list.size()];
//        for ( int i = 0 ; i < list.size() ; i++ ) {
//            array[i] = list.get(i);
//        }
        System.out.print("Array : " + Arrays.toString(array));
        System.out.print("\nEnter search elements from array : ");
        Scanner scanElement = new Scanner(System.in);
        var searchElement = scanElement.nextInt();
        Integer index = performBinarySearch(array, searchElement);
        if (index >= 0) {
            System.out.print("\nElement found at : " + index);
        } else {
            System.out.print("\nElement not found in array");
        }

    }
    private static Integer performBinarySearch(int[] array, int searchElement) {
        Arrays.sort(array);

        //{2,2,3,4,4,5,6,7}

        System.out.print("Sorted Array : " + Arrays.toString(array));
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == searchElement) {
                return mid;
            } else if (array[mid] > searchElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
        //Time Complexity
//  n/2^k=1
//  n=2^k
//  log n = log(2^k)
//  log n = k log 2
//
//
//

    }
}
