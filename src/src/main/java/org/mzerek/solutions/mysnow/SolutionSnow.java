package org.mzerek.solutions.mysnow;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.max;
import static java.lang.Math.min;

//https://www.csestack.org/snow-between-hills-coding-challenge/
public class SolutionSnow {

    public static void main(String[] str) {

        int[] table = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};

        int sum = computeSnowpack(table);

        System.out.println("Suma: " + sum);

        //JUnitCore.main("Solution");


/*        Result result = JUnitCore.runClasses(SolutionSnow.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());*/
    }

    @Test
    public void addFirstTest() {
        //is
        int[] table1 = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        int[] table2 = {2, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        int[] table3 = {2, 1, 3};

        //when
        int sum1 = computeSnowpack(table1);
        int sum2 = computeSnowpack(table2);
        int sum3 = computeSnowpack(table3);

        //expected
        Assert.assertEquals(sum1, 13);
        Assert.assertEquals(sum2, 14);
        Assert.assertEquals(sum3, 1);
    }

    public static int computeSnowpack(int[] table) {

        int[] leftTable = new int[table.length];
        int[] rightTable = new int[table.length];

        int leftMax = table[0];
        int rightMax = table[table.length - 1];

        for (int i = 0; i < table.length; i++) {
            /*if (leftMax < table[i]) {
                leftMax = table[i];
            }*/
            leftMax = max(leftMax, table[i]);
            leftTable[i] = leftMax;
        }

        for (int i = table.length - 1; i > -1; i--) {
            /*if (rightMax < table[i]) {
                rightMax = table[i];
            }*/
            rightMax = max(rightMax, table[i]);
            rightTable[i] = rightMax;
        }

        /*System.out.println("==leftTable===================");
        for (int s : leftTable) {
            System.out.println(s);
        }
        System.out.println("=====================");

        System.out.println("==rightTable===================");

        for (int s : rightTable) {
            System.out.println(s);
        }
        System.out.println("=====================");*/

        int sum = 0;

        for (int i = 0; i < table.length; i++) {
            //System.out.println(min(leftTable[i], rightTable[i]) + " -  " + table[i] + " = " + (min(leftTable[i], rightTable[i]) - table[i]));
            sum = sum + min(leftTable[i], rightTable[i]) - table[i];
        }


        return sum;
    }
}
