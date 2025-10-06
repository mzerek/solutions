package main.java.org.mzerek.solutions.javathreads_01.barrierpattern;

/*
https://www.geeksforgeeks.org/java/cyclicbarrier-in-java-with-examples/
 */
public class BarrierExample {

    public static void main(String[] args) {
        MainCalc calc = new MainCalc();
        Thread mThread = new Thread(calc);
        mThread.setName("MainCalcThread");
        mThread.start();
    }
}
