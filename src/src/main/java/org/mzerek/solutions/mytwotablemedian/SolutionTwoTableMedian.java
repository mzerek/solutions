package org.mzerek.solutions.mytwotablemedian;

//https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/

import java.util.Arrays;

public class SolutionTwoTableMedian {

    public static void main(String[] args) {
        int[] table = {3, 5, 1, 7, 4, 11, 6, 12, 86, 32, 9};

        int[] table2 = {8, 17, 66, 2, 27, 32, 5};

        double median = fetchTwoTableMedian(table, table2);

        System.out.println(median);
    }

    public static double fetchTwoTableMedian(int[] table, int[] table2) {

        int[] twoTable = new int[table.length + table2.length];
        System.arraycopy(table, 0, twoTable, 0, table.length);
        System.arraycopy(table2, 0, twoTable, table.length, table2.length);


        Arrays.sort(twoTable);

        for (int s : twoTable) {
            System.out.println(s);
        }
        System.out.println("3=====================");



        if (twoTable.length % 2 != 0) {
            return (double) twoTable[twoTable.length / 2];
        }

        return (double) (twoTable[(twoTable.length - 1) / 2] + twoTable[twoTable.length / 2]) / 2.0;
    }
}
