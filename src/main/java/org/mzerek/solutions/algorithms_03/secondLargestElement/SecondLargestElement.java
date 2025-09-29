package main.java.org.mzerek.solutions.algorithms_03.secondLargestElement;

import java.util.Arrays;

//https://www.geeksforgeeks.org/dsa/find-second-largest-element-array/
public class SecondLargestElement {

    public static void main(String[] args) {
        int[] table = {12, 35, 1, 10, 34, 1};
        //int[] table = {10, 5, 10};
        //int[] table = {10, 10, 10};
        //int[] table = {12};
        int secondLargestElement = findSecondLargestElement(table);
        System.out.println("Result: " + secondLargestElement);
    }

    public static int findSecondLargestElement(int[] table) {
        Arrays.sort(table);
        for (int i = table.length - 1; i >= 1; i--) {
            if (table[i] > table[i - 1]) {
                return table[i - 1];
            }
        }
        return -1;
    }
}
