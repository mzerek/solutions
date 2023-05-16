package org.mzerek.solutions.mypairofsum;

//https://www.geeksforgeeks.org/count-pairs-with-given-sum/
public class SolutionPairOfSum {

    int pairOfSum(int[] table, int sum) {
        int pairCounter = 0;

        for (int i = 0; i < table.length; i++) {
            for (int j = i + 1; j < table.length; j++) {
                if ((table[i] + table[j]) == sum) {
                    pairCounter++;
                }
            }
        }

        return pairCounter;
    }

    public static void main(String[] args) {
        SolutionPairOfSum spos = new SolutionPairOfSum();
        int[] table = {1, 5, 7, -1, 5};
        int sum = 6;

        int pairs = spos.pairOfSum(table, sum);

        System.out.println("Pairs number: " + pairs);

        int[] table2 = {1, 1, 1, 1};
        int sum2 = 2;

        pairs = spos.pairOfSum(table2, sum2);

        System.out.println("Pairs number: " + pairs);

        int[] table3 = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int sum3 = 11;

        pairs = spos.pairOfSum(table3, sum3);

        System.out.println("Pairs number: " + pairs);
    }
}
