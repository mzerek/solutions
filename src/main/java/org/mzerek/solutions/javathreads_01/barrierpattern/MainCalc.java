package main.java.org.mzerek.solutions.javathreads_01.barrierpattern;

import main.java.org.mzerek.solutions.javathreads_01.thread_runnable.ThreadExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainCalc implements Runnable {

    public static CyclicBarrier barrier = new CyclicBarrier(3);
    @Override
    public void run() {
        Calc1 calc1 = new Calc1();
        Calc2 calc2 = new Calc2();

        Thread c1 = new Thread(calc1);
        c1.setName("Calc1Thread");
        Thread c2 = new Thread(calc2);
        c2.setName("Calc2Thread");

        c1.start();
        c2.start();

/*        try {
            c1.start();
            c1.join();
            c2.start();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            MainCalc.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of product and sum = " + (Calc1.calcOneValue + Calc2.calcTwoValue));

        MainCalc.barrier.reset();
        System.out.println("Barrier reset successful");
    }
}
