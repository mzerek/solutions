package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz_02;

/*
https://stormit.pl/fizzbuzz/
 */
public class FizzBuzzV3 {

    public static void main(String[] args) {
        StringBuilder message = new StringBuilder();
        for(int i = 1; i<=100; i++){
            if(i % 15 == 0) {
                message.append("FizzBuzz \n");
            } else if (i % 3 == 0) {
                message.append("Fizz \n");
            } else if (i % 5 == 0) {
                message.append("Buzz \n");
            } else {
                message.append(i + "\n");
            }
        }

        System.out.println(message);
    }
}
