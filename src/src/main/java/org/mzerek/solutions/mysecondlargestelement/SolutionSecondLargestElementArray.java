package org.mzerek.solutions.mysecondlargestelement;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-second-largest-element-array/

public class SolutionSecondLargestElementArray {

    public static void secondLargestElement(int[] table) {

        System.out.println("Given array: " + Arrays.toString(table));

        int tableSize = table.length;

        if (tableSize < 2) {
            System.out.println("To small table to check: " + Arrays.toString(table));
            return;
        }

        Arrays.sort(table);
        int largest = table[tableSize - 1];
        int secondLargest = -1;

        for (int i = tableSize - 2; i >= 0; i--) {
            if (table[i] != largest) {
                secondLargest = table[i];
                System.out.println("Largest element is: " + largest + " second largest element is: " + secondLargest);
                return;
            }
        }

        System.out.println("Not exist second largest element in table " + Arrays.toString(table));
    }

    public static void main(String[] args) {
        int[] table = {12, 35, 1, 10, 34, 1};
        int[] table2 = {12};
        int[] table3 = {12, 12, 12};
        int[] table4 = {};
        secondLargestElement(table);
        secondLargestElement(table2);
        secondLargestElement(table3);
        secondLargestElement(table4);
    }
}
