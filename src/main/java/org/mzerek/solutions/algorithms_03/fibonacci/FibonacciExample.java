package main.java.org.mzerek.solutions.algorithms_03.fibonacci;

public class FibonacciExample {

    public static void main(String[] args) {
        int value = 12;
        printFibonacci(value);
        System.out.println("End");
    }

    public static void printFibonacci(int value) {
        int sum = 0;
        int[] fibValue = new int[value+1];
        for(int i = 0; i<=value; i++){
            if(i == 0) {
                fibValue[i] = i;
                System.out.println("i:"+ i + " fibValue: " + fibValue[i]);
            } else if(i == 1) {
                fibValue[i] = i;
                sum = sum + fibValue[i];
                System.out.println("i:"+ i + " fibValue: " + fibValue[i]);
             }else {
                fibValue[i] = fibValue[i-2] + fibValue[i-1];
                sum = sum + fibValue[i];
                System.out.println("i:"+ i + " fibValue: " + fibValue[i]);
            }
        }
        System.out.println("Sum: " + sum);
    }
}
