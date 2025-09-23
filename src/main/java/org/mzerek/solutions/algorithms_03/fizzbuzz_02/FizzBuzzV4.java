package main.java.org.mzerek.solutions.algorithms_03.fizzbuzz_02;

/*
https://stormit.pl/fizzbuzz/
 */
public class FizzBuzzV4 {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(100));
    }

    public static String fizzBuzz(int n) {
        String s = "";
        if(n == 0){
            return s;
        }
        if(n % 5 == 0){
            s = "Buzz" + s;
        }
        if(n % 3 == 0){
            s = "Fizz" + s;
        }
        if(s.equals("")){
            s = n + "";
        }

        return fizzBuzz(n - 1) + s + "\n";
    }
}
