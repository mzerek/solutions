package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz;

/*
https://stormit.pl/fizzbuzz/
 */
public class FizzBuzzV5 {

    public static void main(String[] args) {
        Sound sound = new Sound(3, "Fizz", new Sound(5, "Buzz"));
        for (int i = 1; i <= 100; i++) {
            System.out.println(sound.generate(i));
        }
    }
}
