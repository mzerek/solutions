package org.mzerek.solutions.mypower;

//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
public class SolutionPower {

    public static long power(int x, int n) {
        long power = 1L;

        for (int i = 0; i < n; i++) {
            power = power * x;

        }
        return power;
    }

    public static void main(String[] arg) {

        long one = power(2, 2);
        long two = power(3, 2);
        long three = power(12, 4);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }
}
