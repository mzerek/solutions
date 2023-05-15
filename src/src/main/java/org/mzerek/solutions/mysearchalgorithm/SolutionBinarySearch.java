package org.mzerek.solutions.mysearchalgorithm;

import java.util.Arrays;

//https://www.geeksforgeeks.org/binary-search/
public class SolutionBinarySearch {

    int binarySearch(int[] table, int x) {

        int low = 0;
        int height = table.length - 1;

        while (low <= height) {
            int index = low + (height - 1) / 2;
            if (table[index] == x) {
                return index;
            } else if (table[index] < x) {
                low = index + 1;
            } else
                height = index - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Binaray search for sorted array");

        int[] table = {7, 2, 15, 6, 9, 4, 76, 55, 10, 40};

        System.out.println("Given array: " + Arrays.toString(table));

        Arrays.sort(table);
        System.out.println("Sorted array: " + Arrays.toString(table));

        SolutionBinarySearch solutionBinarySearch = new SolutionBinarySearch();
        int index = solutionBinarySearch.binarySearch(table, 55);

        System.out.println("Result for sorted array: " + index);
    }
}
