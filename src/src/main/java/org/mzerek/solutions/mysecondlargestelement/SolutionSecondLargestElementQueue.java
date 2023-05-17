package org.mzerek.solutions.mysecondlargestelement;

import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

//https://www.geeksforgeeks.org/find-second-largest-element-array/

public class SolutionSecondLargestElementQueue {

    public static void secondLargestElement(int[] table) {

        List<Integer> valuesList = Arrays.stream(table).boxed().distinct().collect(toList());

        PriorityQueue<Integer> priorityQueueValues = new PriorityQueue<>(reverseOrder());

        priorityQueueValues.addAll(valuesList);

        Integer largesElement = priorityQueueValues.poll();
        System.out.println("Largest element in table is: " + largesElement);

        if (priorityQueueValues.peek() == null) {
            System.out.println("Not exist second largest element in table " + Arrays.toString(table));
        } else {
            System.out.println("Second largest element in table is: " + priorityQueueValues.peek());
        }


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
