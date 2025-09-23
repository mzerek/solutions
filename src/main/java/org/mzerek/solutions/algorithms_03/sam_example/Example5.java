package main.java.org.mzerek.solutions.algorithms_03.sam_example;

import java.util.*;

/*
Write a function:
class Solution {
    public int solution (int[] A);
}
that, given an array A of N integers, returns the
smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [-1, -3], the function should return 1.
*/

public class Example5 {

    public static void main(String[] args) {

        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println("Result: " + returnMax(A));

        int[] B = {1, 2, 3};
        System.out.println("Result: " + returnMax(B));

        int[] C = {-1, -3};
        System.out.println("Result: " + returnMax(C));
    }

    public static int returnMax(int[] A) {
        List<Integer> mainList = Arrays.stream(A).boxed().toList();

        //List<Integer> mainList = new ArrayList<>();
        //for(int i=0; i<A.length; i++){
        //mainList.add(A[i]);
        //}

        int listSize = mainList.size();

        Integer maxListVal = Collections.max(mainList);
        //System.out.println("Max: " + maxListVal);
        if (maxListVal < 0) {
            //System.out.println("Three");
            return 1;
        }
        for (int i = 1; i <= maxListVal; i++) {
            if (!mainList.contains(i) && i < maxListVal) {
                //System.out.println("One");
                return i;
            } else if (i >= maxListVal) {
                //System.out.println("Two");
                return i + 1;
            }
        }
        return 0;
    }
}
