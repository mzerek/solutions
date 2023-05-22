package org.mzerek.solutions.myzeroesattheend;

import java.util.Arrays;

//https://www.geeksforgeeks.org/move-zeroes-end-array/
public class SolutionZeroesAtTheEnd {

    public static void main(String[] args) {
        int[] table = {1, 2, 0, 4, 3, 0, 5, 0};
        int[] table2 = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int[] table3 = {1, 2, 0, 0, 0, 3, 6};

        System.out.println("Given list: " + Arrays.toString(table));
        System.out.println("With zeroes at the end list: " + Arrays.toString(zeroesAtTheEnd(table)));
        System.out.println(" ");

        System.out.println("Given list: " + Arrays.toString(table2));
        System.out.println("With zeroes at the end list: " + Arrays.toString(zeroesAtTheEnd(table2)));
        System.out.println(" ");

        System.out.println("Given list: " + Arrays.toString(table3));
        System.out.println("With zeroes at the end list: " + Arrays.toString(zeroesAtTheEnd(table3)));
        System.out.println(" ");
    }

    public static int[] zeroesAtTheEnd(int[] table){
        int tableLength = table.length;

        int[] tmpTable = new int[tableLength];

        int count = 0;
        for(int i =0; i< tableLength; i++){
            if(table[i] != 0) {
                tmpTable[count ++] = table[i];
            }
        }

        for(int i = count; i < tableLength; i++){
            tmpTable[i] = 0;
        }

        return tmpTable;
    }
}
