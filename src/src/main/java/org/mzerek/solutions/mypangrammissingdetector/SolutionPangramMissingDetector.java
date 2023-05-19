package org.mzerek.solutions.mypangrammissingdetector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/missing-characters-make-string-pangram/

public class SolutionPangramMissingDetector {

    public static void main(String[] args) {

/*        String one = findMissingChartInPangram("The quick brown fox jumps over the lazy dog");
        String two = findMissingChartInPangram("The slow purple oryx meanders past the quiescent canine");
        String three = findMissingChartInPangram("We hates Bagginses!");
        String four = findMissingChartInPangram("");

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);*/

        //JUnitCore.main("Solution");

        Result result = JUnitCore.runClasses(SolutionPangramMissingDetector.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Test
    public void addFirstTest() {
        //is
        String one = "The quick brown fox jumps over the lazy dog";
        String two = "The slow purple oryx meanders past the quiescent canine";
        String three = "We hates Bagginses!";
        String four = "";

        //when
        String result0ne = findMissingChartInPangram(one);
        String resultTwo = findMissingChartInPangram(two);
        String resultThree = findMissingChartInPangram(three);
        String resultFour = findMissingChartInPangram(four);

        //expected
        Assert.assertEquals(result0ne, "The string is a pangram.");
        Assert.assertEquals(resultTwo, "bfgjkvz");
        Assert.assertEquals(resultThree, "cdfjklmopqruvxyz");
        Assert.assertEquals(resultFour, "abcdefghijklmnopqrstuvwxyz");
    }

    public static String findMissingChartInPangram(String phraze) {

        phraze = phraze.toLowerCase();

        Set<Character> charSentence = new HashSet<>();

        for (int i = 0; i < phraze.length(); i++) {
            char c = phraze.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charSentence.add(c);
            }
        }

        StringBuilder missingChar = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!charSentence.contains(c)) {
                missingChar.append(c);
            }
        }

        if (missingChar.length() == 0) {
            return "The string is a pangram.";
        }

        return missingChar.toString();
    }


}
