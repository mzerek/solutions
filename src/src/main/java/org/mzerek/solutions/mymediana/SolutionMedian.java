package org.mzerek.solutions.mymediana;

//https://www.geeksforgeeks.org/median/

import java.util.Arrays;

public class SolutionMedian {

    public static void main(String[] args) {
        //Integer[] table = {3, 5, 1, 7, 4, 11, 6, 12, 86, 32, 9};
        Integer[] table = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 11, 12, 17, 27, 32, 32, 66, 86};


        double median = fetchMedian(table, table.length);

        System.out.println(median);
    }

    public static double fetchMedian(Integer[] table, Integer length) {

        Arrays.sort(table);

        if (length % 2 != 0) {
            return (double) table[length / 2];
        }


        return (double) (table[(length - 1) / 2] + table[length / 2]) / 2.0;
    }
}
