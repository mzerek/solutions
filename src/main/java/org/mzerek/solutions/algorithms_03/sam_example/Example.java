package main.java.org.mzerek.solutions.algorithms_03.sam_example;

import java.util.Arrays;
import java.util.List;

public class Example {

    public static String UP = "U";
    public static String DOWN = "D";

    public static String HORIZONTAL = "H";

    public static void main(String[] args) {
        System.out.println("Main method");
        moveFish("DHUUDDUU");
    }

    public static void moveFish(String steps) {
        int movesNumbers = 0;

        String[] array = steps.split("");
        List<String> moves = Arrays.asList(array);
        System.out.println(moves);

        int counter = 0;
        for (String move : moves) {
            switch (move) {
                case "U" -> {
                        movesNumbers = movesNumbers + 1;
                        if (movesNumbers == 1) {
                            counter = counter + 1;
                        }
                    }
                case "D" -> {
                    movesNumbers = movesNumbers - 1;
                }
            }

/*            if (move.equals(UP)) {
                movesNumbers = movesNumbers + 1;
                System.out.println("UP Start: " + movesNumbers);
                if (movesNumbers == 1) {
                    counter = counter + 1;
                    System.out.println("counter: " + counter);
                }
            }
            if (move.equals(DOWN)) {
                movesNumbers = movesNumbers - 1;
                System.out.println("DOWN Start: " + movesNumbers);
            }
            if(move.equals(HORIZONTAL)){
                System.out.println("HORIZONTAL Start: " + movesNumbers);
            }*/
        }

        System.out.println("Ryba wyskoczyła: " + counter + " razy");
    }
}
