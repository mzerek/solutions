package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/*
https://stormit.pl/fizzbuzz/
 */
public class FizzBuzzV6 {

    public static void main(String[] args) {
        int[] x = new int[101];
        Arrays.setAll(x, IntUnaryOperator.identity());
        Arrays.stream(x).forEach(i -> {
            if(i == 0) return;
            String output = "";
            if(i % 3 == 0) output+="Fizz";
            if(i % 5 == 0) output+="Buzz";
            if(output.equals("")) output+=i;

            System.out.println(output);
        });
    }
}
