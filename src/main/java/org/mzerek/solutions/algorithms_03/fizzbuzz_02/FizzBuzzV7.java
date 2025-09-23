package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz_02;

import java.util.stream.IntStream;

/*
https://stormit.pl/fizzbuzz/
 */
public class FizzBuzzV7 {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> {
                    if (i % (15) == 0) {
                        return "FizzBuzz";
                    } else if (i % 3 == 0) {
                        return "Fizz";
                    } else if (i % 5 == 0) {
                        return "Buzz";
                    } else {
                        return Integer.toString(i);
                    }
                }).forEach(System.out::println);
    }
}
