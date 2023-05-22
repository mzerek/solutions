package org.mzerek.solutions.myexistinrangenumber;

import java.util.*;
import java.util.stream.Collectors;

//https://www.geeksforgeeks.org/queries-to-check-if-a-number-lies-in-n-ranges-of-l-r/

public class SolutionRangeNumber {

    public static void main(String[] args) {

        int[][] ranges = {{5, 6}, {1, 3}, {8, 10}};
        int[] values = {2, 3, 4, 7};

/*        int[][] ranges = {{5, 8}, {12, 15}, {10, 15}};
        int[] values = {2, 3, 7};*/

        System.out.println(checkExistInRange(ranges, values));

    }

    public static List<String> checkExistInRange(int[][] ranges, int[] values) {

        List<List<Integer>> rangesList = new ArrayList<>();
        for (int[] rows : ranges) {
            rangesList.add(Arrays.stream(rows)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        rangesList.sort(Comparator.comparing(l -> l.get(0)));

        System.out.println("Sorted ranges list: " + Arrays.toString(rangesList.toArray()));

        List<String> answers = new ArrayList<>();
        for (int value : values) {
            answers.add(isValueInRange(rangesList, value));
        }
        return answers;
    }

    public static String isValueInRange(List<List<Integer>> rangesList, int value) {

        String answer = "No";
        for (List<Integer> range : rangesList) {
            if (Math.max(range.get(0), value) == Math.min(value, range.get(1))) {
                answer = "Yes";
                break;
            }
        }
        return answer;
    }
}
