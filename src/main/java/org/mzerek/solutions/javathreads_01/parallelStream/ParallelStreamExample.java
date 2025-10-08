package main.java.org.mzerek.solutions.javathreads_01.parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Strumień sekwencyjny
        System.out.println("Strumień sekwencyjny:");
        numbers.stream()
                .map(n -> {
                    System.out.println("Sekwencyjnie: " + n);
                    return n * 2;
                })
                .collect(Collectors.toList());

        System.out.println("\n--------------------\n");

        // Strumień równoległy
        System.out.println("Strumień równoległy:");
        numbers.parallelStream()
                .map(n -> {
                    System.out.println("Równolegle: " + n);
                    return n * 2;
                })
                .collect(Collectors.toList());
    }
}
