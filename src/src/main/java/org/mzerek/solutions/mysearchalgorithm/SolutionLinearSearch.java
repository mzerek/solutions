package org.mzerek.solutions.mysearchalgorithm;

import java.util.Arrays;

public class SolutionLinearSearch {

    int linearSearch(int[] table, int x) {
        int size = table.length;

        for (int i=0; i<size; i++) {
            if(table[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Linear search for array");

        int[] table = {7, 2, 15, 6, 9, 4, 76, 55, 10, 40};

        System.out.println("Given array: " + Arrays.toString(table));

        SolutionLinearSearch solutionLinearSearch = new SolutionLinearSearch();
        int index = solutionLinearSearch.linearSearch(table, 55);

        System.out.println("Result index for array: " + index);
    }
}
