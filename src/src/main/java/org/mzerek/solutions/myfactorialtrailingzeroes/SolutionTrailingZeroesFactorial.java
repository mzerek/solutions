package org.mzerek.solutions.myfactorialtrailingzeroes;

import java.math.BigInteger;

//https://www.purplemath.com/modules/factzero.htm
//https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/

public class SolutionTrailingZeroesFactorial {

    public static void main(String[] args) {
        int number = 5;
        BigInteger bigNumber = BigInteger.valueOf(number);
        BigInteger factorial = factorialExample(bigNumber);

        System.out.println("Factorial from " + number + " is: " + factorial);

        int number2 = 5;
        int countZeroes = findTrailingZeros(number2);
        System.out.println("Trailing zeroes for " + number2 + " is: " + countZeroes);

    }

    public static int findTrailingZeros(int n) {
        if(n < 0) {
            return -1;
        }

        int counter = 0;

        for (int i = 5; n / i >= 1; i *=5) {
            System.out.println(" ");
            System.out.println("begin ================");
            System.out.println("i= " + i);
            System.out.println("counter= " + counter);

            counter = counter + n / i;

            System.out.println("counter= " + counter);
            System.out.println("end  ================");
        }

        return counter;
    }

    public static BigInteger factorialExample(BigInteger number) {

        BigInteger factorial = BigInteger.valueOf(1);

        for(int i=1; i <= number.intValue(); i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
