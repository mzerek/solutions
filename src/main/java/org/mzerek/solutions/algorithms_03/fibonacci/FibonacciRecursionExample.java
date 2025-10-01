package main.java.org.mzerek.solutions.algorithms_03.fibonacci;

public class FibonacciRecursionExample {

    public static void main(String[] args) {
        int value = 12;
        for (int i = 0; i <= value; i++) {
            System.out.print(printFibonacci(i) + " ");
        }
    }

    public static int printFibonacci(int value) {
        if(value <= 1){
            return value;
        }
        return printFibonacci(value-2) + printFibonacci(value-1);
    }
}
