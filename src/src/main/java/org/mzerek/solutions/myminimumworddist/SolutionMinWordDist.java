package org.mzerek.solutions.myminimumworddist;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/
public class SolutionMinWordDist {

    public static void main(String[] args) {
        String s = "geeks for geeks contribute for practice practice";
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(findWordDistance(s, w1, w2));
    }

    private static int findWordDistance(String phrase, String wOne, String wTwo) {

        if (wOne.equals(wTwo)) {
            return 0;
        }

        String[] wordArray = phrase.split(" ");
        int arrayLength = wordArray.length;

        int firstWordIndex = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (wordArray[i].equals(wOne)) {
                firstWordIndex = i;
            }
        }

        int secondWordIndex = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (wordArray[i].equals(wTwo)) {
                secondWordIndex = i;
                break;
            }
        }

        System.out.println("Array of words: " + Arrays.toString(wordArray));
        System.out.println("First index: " + firstWordIndex);
        System.out.println("Second index: " + secondWordIndex);

        int distance = Math.abs(firstWordIndex - secondWordIndex) - 1;

        return distance;
    }
}
